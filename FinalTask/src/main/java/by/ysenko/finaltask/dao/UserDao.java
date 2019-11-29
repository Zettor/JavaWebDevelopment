package by.ysenko.finaltask.dao;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends Dao<User> {

    public List<User> findByArgs(String login, String sort) throws SQLException;

    public User findUser(String login,String password) throws PersistentException;
}
