package by.ysenko.finaltask.dao.connection;

import by.ysenko.finaltask.dao.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {


    private String url;
    private String user;
    private String password;
    private int maxSize;
    private int checkConnectionTimeout;

    private static ReentrantLock locker = new ReentrantLock();



    private BlockingQueue<PoolConnection> freeConnections = new LinkedBlockingQueue<>();
    private Set<PoolConnection> usedConnections = new ConcurrentSkipListSet<>();

    private ConnectionPool() {
    }

    public  Connection getConnection() {
        locker.lock();
        PoolConnection connection = null;
        while (connection == null) {
            try {
                if (!freeConnections.isEmpty()) {
                    connection = freeConnections.take();
                    if (!connection.isValid(checkConnectionTimeout)) {
                        try {
                            connection.getConnection().close();
                        } catch (SQLException e) {
                        }
                        connection = null;
                    }
                } else if (usedConnections.size() < maxSize) {
                    connection = createConnection();
                } else {

                }
            } catch (InterruptedException | SQLException e) {

            }
        }
        usedConnections.add(connection);
        locker.unlock();
        return connection;
    }

     void freeConnection(PoolConnection connection) {

        locker.lock();
        try {
            if (connection.isValid(checkConnectionTimeout)) {
                connection.clearWarnings();
                connection.setAutoCommit(true);
                usedConnections.remove(connection);
                freeConnections.put(connection);
            }
        } catch (SQLException | InterruptedException e1) {

            try {
                connection.getConnection().close();
            } catch (SQLException e2) {
            }
        }
        locker.unlock();
    }

    public  void init()  {

        locker.lock();
        try {
            destroy();
            ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
            Class.forName(resourceBundle.getString("driver_class"));
            this.url = resourceBundle.getString("url");
            this.user = resourceBundle.getString("user");
            this.password = resourceBundle.getString("password");
            this.maxSize = Integer.parseInt(resourceBundle.getString("max_size"));
            this.checkConnectionTimeout = Integer.parseInt(resourceBundle.getString("check_connection_timeout"));
            for (int counter = 0; counter < Integer.parseInt(resourceBundle.getString("start_size")); counter++) {
                freeConnections.put(createConnection());
            }

        } catch (ClassNotFoundException | InterruptedException | SQLException e) {
        }
        locker.unlock();
    }

    private static ConnectionPool instance = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return instance;
    }

    private PoolConnection createConnection() throws SQLException {

        return new PoolConnection(DriverManager.getConnection(url, user, password));
    }

    public  void destroy() {
        locker.lock();
        usedConnections.addAll(freeConnections);
        freeConnections.clear();
        for (PoolConnection connection : usedConnections) {
            try {
                connection.getConnection().close();
            } catch (SQLException e) {
            }
        }
        usedConnections.clear();
        locker.unlock();
    }


}

