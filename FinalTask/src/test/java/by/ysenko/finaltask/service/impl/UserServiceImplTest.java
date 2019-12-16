package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.factories.TransactionFactory;
import by.ysenko.finaltask.dao.factories.impl.TransactionFactoryImpl;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.exceptions.DataExistsException;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.*;
import java.util.Date;

import static org.testng.Assert.*;

public class UserServiceImplTest {

    Connection connection;


    private List<Integer> idList = new ArrayList<>();

    @BeforeClass
    private void initConnection() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        String driver = resourceBundle.getString("driver_class");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {

        }

        new TransactionFactoryImpl().init();
    }

    @DataProvider(name = "UsersForSignUp")
    Object[][] createUsersForSignUpTest() {
        return new Object[][]{
                {new User("one", "one", "one", "sasaasenko0@gmail.com", new Timestamp(new Date().getTime()), 0, 1)}

        };
    }

    @Test(dataProvider = "UsersForSignUp")
    public void testSignUp(User user) {

        UserService service = ServiceFactory.createUserService();
        Integer userId = null;

        try {
            userId = service.signUp(user);
        } catch (DataExistsException e) {
            e.printStackTrace();
        }


        Assert.assertTrue(userId != null);
    }


    @AfterTest
    private void closeConnection() {


        new TransactionFactoryImpl().close();
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?;")) {

            for (Integer id : idList) {
                statement.setInt(1, id);
                statement.executeUpdate();

            }

        } catch (SQLException ex) {
            System.out.println("KVDDDDDD");
        }


        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("KVDDDDDD");
        }

        Enumeration<Driver> drivers = DriverManager.getDrivers();

        while (drivers.hasMoreElements()) {
            try {
                DriverManager.deregisterDriver(drivers.nextElement());
            } catch (SQLException e) {

            }
        }

    }
}