package by.ysenko.finaltask.dao;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends Dao<User> {

    public User findUserByEmail(String email) throws DaoException;
    public User findUserByLogin(String login) throws DaoException;


}
