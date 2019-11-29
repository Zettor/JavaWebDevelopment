package by.ysenko.finaltask.service.impl;


import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.UserDao;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.UserService;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends ServiceImpl implements UserService {


    @Override
    public List<User> findAll() throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        transaction.begin(userDao);
        List<User> users = userDao.findAll();
        transaction.end();
        return users;
    }

    @Override
    public User findById(Integer id) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        transaction.begin(userDao);
        User user = userDao.findEntityById(id);
        transaction.end();
        return user;
    }

    @Override
    public Integer signUp(User user) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        transaction.begin(userDao);

//        user.setPassword(aes(user.getPassword().getBytes(), Cipher.ENCRYPT_MODE));
        Integer id = userDao.create(user);

        transaction.end();
        return id;

    }

    @Override
    public void editUser(User user) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        transaction.begin(userDao);

//        user.setPassword(aes(user.getPassword().getBytes(), Cipher.ENCRYPT_MODE));
        userDao.update(user);

        transaction.end();


    }

    @Override
    public User signIn(String login,String password) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        transaction.begin(userDao);

//        user.setPassword(aes(user.getPassword().getBytes(), Cipher.ENCRYPT_MODE));
        User user = userDao.findUser(login,password);

        transaction.end();
        return user;

    }

    @Override
    public void delete(Integer identity) throws PersistentException {

    }

    public String aes(byte[] rawMessage, int cipherMode) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey secretKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);
            byte[] output = cipher.doFinal(rawMessage);
            return new String(output);
        } catch (Exception e) {
            return null;
        }
    }
}
