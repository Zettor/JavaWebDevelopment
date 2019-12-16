package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.GenreDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.UserDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GenreService;

import java.util.List;

public class GenreServiceImpl extends ServiceImpl implements GenreService {
    @Override
    public List<Genre> findAll()  {
        Transaction transaction = transactionFactory.createTransaction();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(genreDao);
        List<Genre> genres=null;
        try {
             genres = genreDao.findAll();
             transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();
        return genres;
    }

    @Override
    public void delete(int id)  {
        Transaction transaction = transactionFactory.createTransaction();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(genreDao);
        try {
            genreDao.delete(id);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();

    }

    @Override
    public void add(Genre genre)  {
        Transaction transaction = transactionFactory.createTransaction();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(genreDao);
        try {
            genreDao.create(genre);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();

    }
}
