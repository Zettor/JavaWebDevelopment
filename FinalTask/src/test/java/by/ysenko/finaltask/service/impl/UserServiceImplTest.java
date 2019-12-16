package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.factories.TransactionFactory;
import by.ysenko.finaltask.dao.factories.impl.TransactionFactoryImpl;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.exceptions.DataExistsException;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;
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

    @DataProvider(name = "RightUsersForSignUp")
    Object[][] createRightUsersForSignUpTest() {
        return new Object[][]{
                {new User("one", "oneeee", "one", "sasaasenko0@gmail.com", new Timestamp(new Date().getTime()), 0, 1)},
                {new User("two2", "twoooo2", "two", "sasSdasWasenko0@gmail.com", new Timestamp(new Date().getTime()), 1, 0)},
                {new User("three3", "three3", "two2013", "sa2013saasenko0@gmail.com", new Timestamp(new Date().getTime()), 0, 0)}

        };
    }

    @DataProvider(name = "NotRightUsersForSignUp")
    Object[][] createNotRightUsersForSignUpTest() {
        return new Object[][]{
                {new User("one@#@", "oneeee", "one", "sasaasenko0@gmail.com", new Timestamp(new Date().getTime()), 0, 1)},
                {new User("two", "asdasd@#@!#", "two", "sasSdasWasenko0@gmail.com", new Timestamp(new Date().getTime()), 1, 0)},
                {new User("three3", "three3", "three2013", "sa@E2312013saasenko0@gmail.com", new Timestamp(new Date().getTime()), 0, 0)},
                {new User("four4", "four4", "four2013", "sasaasenko0@gmail.com", new Timestamp(new Date().getTime()), 4, 0)},
                {new User("five5", "five5", "five2013", "sasaasenko0@gmail.com", new Timestamp(new Date().getTime()), 0, 3)},

        };
    }

    @Test(dataProvider = "RightUsersForSignUp")
    public void testSignUp(User user) throws IncorrectFormDataException, DataExistsException {

        UserService service = ServiceFactory.createUserService();
        Integer userId = null;
        userId = service.signUp(user);
        idList.add(userId);


        Assert.assertTrue(userId != null);
    }

    @Test(expectedExceptions = {IncorrectFormDataException.class, DataExistsException.class}, dataProvider = "NotRightUsersForSignUp")
    public void testNotRightSignUp(User user) throws IncorrectFormDataException, DataExistsException {

        UserService service = ServiceFactory.createUserService();
        Integer userId = null;
        userId = service.signUp(user);
    }


    @AfterTest
    private void closeConnection() {


        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id = ?;")) {

            for (Integer id : idList) {
                statement.setInt(1, id);
                statement.executeUpdate();

            }

        } catch (SQLException ex) {

        }
        new TransactionFactoryImpl().close();

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