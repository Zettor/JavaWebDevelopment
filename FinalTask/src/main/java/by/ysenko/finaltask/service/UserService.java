package by.ysenko.finaltask.service;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.UserDao;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.exceptions.BlockException;
import by.ysenko.finaltask.service.exceptions.DataExistsException;
import by.ysenko.finaltask.service.exceptions.DataNotException;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;

import java.util.List;

public interface UserService {
    List<User> findAll() ;

    User findById(Integer id);

    Integer signUp(User user)throws DataExistsException;

    public User signIn(String login, String password) throws  IncorrectFormDataException, DataNotException, BlockException;

    public void editUser(User user);

    public void setRole(Integer id, Integer role);

    public void setStatus(Integer id, Integer status);


}
