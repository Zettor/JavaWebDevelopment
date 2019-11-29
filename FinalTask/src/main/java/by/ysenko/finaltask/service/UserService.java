package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.PersistentException;

import java.util.List;

public interface UserService  {
    List<User> findAll() throws PersistentException;

    User findById(Integer id) throws PersistentException;

    Integer signUp(User user) throws PersistentException;

    void delete(Integer identity) throws PersistentException;

    public User signIn(String login,String password) throws PersistentException;

    public void editUser(User user) throws PersistentException;

}
