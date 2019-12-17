package by.ysenko.finaltask.service.impl;


import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.*;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.exceptions.BlockException;
import by.ysenko.finaltask.service.exceptions.DataExistsException;
import by.ysenko.finaltask.service.exceptions.DataNotException;
import by.ysenko.finaltask.service.exceptions.IncorrectFormDataException;
import by.ysenko.finaltask.service.validators.UserValidator;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Formatter;
import java.util.List;

public class UserServiceImpl extends ServiceImpl implements UserService {


    @Override
    public List<User> findAll()  {


        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        CountryDao countryDao = daoFactory.createCountryDao();
        CityDao cityDao = daoFactory.createCityDao();
        transaction.begin(userDao, countryDao, cityDao);
        List<User> users = null;
        try {
            users = userDao.findAll();
            for (User user : users) {
                user.setCountry(countryDao.findEntityById(user.getCountry().getId()));
                user.setCity(cityDao.findEntityById(user.getCity().getId()));
            }
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
        return users;
    }

    @Override
    public User findById(Integer id) {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        CountryDao countryDao = daoFactory.createCountryDao();
        CityDao cityDao = daoFactory.createCityDao();
        transaction.begin(userDao, countryDao, cityDao);
        User user = null;
        try {
            user = userDao.findEntityById(id);
            user.setCountry(countryDao.findEntityById(user.getCountry().getId()));
            user.setCity(cityDao.findEntityById(user.getCity().getId()));
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
        return user;
    }

    @Override
    public Integer signUp(User user) throws DataExistsException, IncorrectFormDataException {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        transaction.begin(userDao);
        Integer id = null;
        try {

            UserValidator validator = new UserValidator();
            validator.validate(user);
            String salt = generateSalt();
            user.setSalt(salt);
            user.setPassword(generateHash(salt, user.getPassword()));

            if (userDao.findUserByLogin(user.getLogin()) != null) {
                throw new DataExistsException("login");
            }
            if (userDao.findUserByEmail(user.getEmail()) != null) {
                throw new DataExistsException("email");
            }
            id = userDao.create(user);
            transaction.commit();
        } catch (DaoException e) {
           transaction.rollback();
        }
        transaction.end();
        return id;

    }

    @Override
    public void editUser(User user)  {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        transaction.begin(userDao);
        try {
//        user.setPassword(aes(user.getPassword().getBytes(), Cipher.ENCRYPT_MODE));
            userDao.update(user);
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();


    }

    @Override
    public void setRole(Integer id, Integer role)  {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        transaction.begin(userDao);
        try {
            User user = userDao.findEntityById(id);
            user.setRole(role);
//
            userDao.update(user);
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
    }

    @Override
    public void setStatus(Integer id, Integer status)  {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        transaction.begin(userDao);
        try {
            User user = userDao.findEntityById(id);
            user.setStatus(status);
//
            userDao.update(user);
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
    }

    @Override
    public User signIn(String login, String password) throws IncorrectFormDataException, DataNotException, BlockException {
        Transaction transaction = transactionFactory.createTransaction();
        UserDao userDao = daoFactory.createUserDao();
        transaction.begin(userDao);
        User user = null;
        try {
            user = userDao.findUserByLogin(login);
            if (user == null) {
                throw new DataNotException("login");
            }
            if (user.getStatus() != 0) {
                throw new BlockException();
            }
            String hashPassword = generateHash(user.getSalt(), password);

            if (!user.getPassword().equals(hashPassword)) {
                throw new IncorrectFormDataException("password");
            }
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
        return user;

    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        Formatter formatter = new Formatter();
        for (int i = 0; i < salt.length; i++) {
            formatter.format("%02X", salt[i]);
        }
        return formatter.toString();
    }

    private String generateHash(String strSalt, String password) {
        byte[] salt = new byte[strSalt.length() / 2];
        for (int i = 0; i < salt.length; i++) {
            int index = i * 2;
            int j = Integer.parseInt(strSalt.substring(index, index + 2), 16);
            salt[i] = (byte) j;
        }
        byte[] hash = null;
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hash = factory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < hash.length; i++) {
            formatter.format("%02X", hash[i]);
        }
        return formatter.toString();
    }


}
