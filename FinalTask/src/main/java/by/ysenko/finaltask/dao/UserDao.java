package by.ysenko.finaltask.dao;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.DaoException;

public interface UserDao extends Dao<User> {

    public User findUserByEmail(String email) throws DaoException;
    public User findUserByLogin(String login) throws DaoException;


}
