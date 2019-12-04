package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.GenreDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.UserDao;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GenreService;

import java.util.List;

public class GenreServiceImpl extends ServiceImpl implements GenreService {
    @Override
    public List<Genre> findAll() throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(genreDao);
        List<Genre> genres = genreDao.findAll();
        transaction.end();
        return genres;
    }

    @Override
    public void delete(int id) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(genreDao);
        genreDao.delete(id);
        transaction.end();

    }

    @Override
    public void add(Genre genre) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(genreDao);
        genreDao.create(genre);
        transaction.end();

    }
}
