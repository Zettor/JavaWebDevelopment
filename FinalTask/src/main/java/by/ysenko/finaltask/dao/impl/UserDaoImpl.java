package by.ysenko.finaltask.dao.impl;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.UserDao;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {


    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public List<User> findAll() throws PersistentException {
        Statement st = null;
        ResultSet rs = null;
        try {
            st = connection.createStatement();

            rs = st.executeQuery("SELECT id,login,password,email,phone,country,state,city,createAt,status,role FROM users");

            ArrayList<User> users = new ArrayList<>();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setCountry(rs.getString("country"));
                user.setState(rs.getString("state"));
                user.setCity(rs.getString("city"));
                user.setCreateDate(rs.getTimestamp("createAt"));
                user.setStatus(rs.getInt("status"));
                user.setRole(rs.getInt("role"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                rs.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                st.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public User findEntityById(int id) throws PersistentException {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT id,login,password,email,phone,country,state,city,createAt,status,role FROM users WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setCountry(resultSet.getString("country"));
                user.setState(resultSet.getString("state"));
                user.setCity(resultSet.getString("city"));
                user.setCreateDate(resultSet.getTimestamp("createAt"));
                user.setStatus(resultSet.getInt("status"));
                user.setRole(resultSet.getInt("role"));
            }
            return user;
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public User findUser(String login,String password) throws PersistentException {

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("SELECT id,login,password,email,phone,country,state,city,createAt,status,role FROM users WHERE login = ? AND password=?");
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setCountry(resultSet.getString("country"));
                user.setState(resultSet.getString("state"));
                user.setCity(resultSet.getString("city"));
                user.setCreateDate(resultSet.getTimestamp("createAt"));
                user.setStatus(resultSet.getInt("status"));
                user.setRole(resultSet.getInt("role"));
            }
            return user;
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                resultSet.close();
            } catch (SQLException | NullPointerException e) {
            }
            try {
                statement.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id=?");

        ps.setInt(1, id);

        ps.execute();

        return true;

    }

    @Override
    public boolean delete(User entity) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id=?");

        ps.setInt(1, entity.getId());

        ps.execute();

        return true;
    }

    @Override
    public Integer create(User entity) throws PersistentException {
        PreparedStatement ps = null;
        ResultSet resultSet=null;
        try {
            ps = connection.prepareStatement("INSERT INTO users (login,password,email,phone,country,state,city,createAt,status,role) VALUES (?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getEmail());
            ps.setString(4, entity.getPhone());
            ps.setString(5, entity.getCountry());
            ps.setString(6, entity.getState());
            ps.setString(7, entity.getCity());
            ps.setTimestamp(8, entity.getCreateDate());
            ps.setInt(9, entity.getStatus());
            ps.setInt(10, entity.getRole());

            ps.execute();
            resultSet = ps.getGeneratedKeys();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            } else {

                throw new PersistentException();
            }
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public void update(User entity) throws PersistentException {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("UPDATE users SET login=?,password=?,email=?,phone=?,country=?,state=?,city=?,createAt=?,status=?,role=? WHERE id=?");
            ps.setString(1, entity.getLogin());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getEmail());
            ps.setString(4, entity.getPhone());
            ps.setString(5, entity.getCountry());
            ps.setString(6, entity.getState());
            ps.setString(7, entity.getCity());
            ps.setTimestamp(8, entity.getCreateDate());
            ps.setInt(9, entity.getStatus());
            ps.setInt(10, entity.getRole());
            ps.setInt(11, entity.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new PersistentException(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException | NullPointerException e) {
            }
        }
    }

    @Override
    public void close(Statement st) {

        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
        }

    }

    @Override
    public List<User> findByArgs(String login, String sort) throws SQLException {
        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery("SELECT id,login,password,email,phone,country,state,city,createAt,status,role FROM users WHERE login LIKE " + login + " " + sort);

        ArrayList<User> users = new ArrayList<>();

        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setCountry(rs.getString("country"));
            user.setState(rs.getString("state"));
            user.setCity(rs.getString("city"));
            user.setCreateDate(rs.getTimestamp("createAt"));
            user.setStatus(rs.getInt("status"));
            user.setRole(rs.getInt("role"));
            users.add(user);
        }

        return users;
    }
}
