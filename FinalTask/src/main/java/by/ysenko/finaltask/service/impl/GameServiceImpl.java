package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.GameDao;
import by.ysenko.finaltask.dao.GenreDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.UserDao;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GameService;
import by.ysenko.finaltask.service.Service;

import java.util.List;

public class GameServiceImpl extends ServiceImpl implements GameService {

    @Override
    public List<Game> findAll() throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        GameDao gameDao = daoFactory.createGameDao();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(gameDao,genreDao);
        List<Game> games = gameDao.findAll();
        for(Game game:games){
            game.setGenre(genreDao.findEntityById(game.getGenre().getId()));
        }
        transaction.end();
        return games;
    }

    @Override
    public Game findById(Integer id) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        GameDao gameDao = daoFactory.createGameDao();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(gameDao,genreDao);
        Game game = gameDao.findEntityById(id);
            game.setGenre(genreDao.findEntityById(game.getGenre().getId()));
        transaction.end();
        return game;
    }

    @Override
    public void delete(int id) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        GameDao gameDao = daoFactory.createGameDao();
        transaction.begin(gameDao);
        gameDao.delete(id);
        transaction.end();
    }

    @Override
    public void add(Game game) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        GameDao gameDao = daoFactory.createGameDao();
        transaction.begin(gameDao);
        gameDao.create(game);
        transaction.end();

    }
}
