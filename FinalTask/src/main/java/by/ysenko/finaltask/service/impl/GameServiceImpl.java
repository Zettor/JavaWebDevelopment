package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.GameDao;
import by.ysenko.finaltask.dao.GenreDao;
import by.ysenko.finaltask.dao.Transaction;
import by.ysenko.finaltask.dao.UserDao;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GameService;
import by.ysenko.finaltask.service.Service;

import java.util.List;

public class GameServiceImpl extends ServiceImpl implements GameService {

    @Override
    public List<Game> findAll()  {
        Transaction transaction = transactionFactory.createTransaction();
        GameDao gameDao = daoFactory.createGameDao();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(gameDao, genreDao);
        List<Game> games = null;
        try {
            games = gameDao.findAll();
            for (Game game : games) {
                game.setGenre(genreDao.findEntityById(game.getGenre().getId()));
            }
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
        return games;
    }

    @Override
    public Game findById(Integer id)  {
        Transaction transaction = transactionFactory.createTransaction();
        GameDao gameDao = daoFactory.createGameDao();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(gameDao, genreDao);
        Game game = null;
        try {
            game = gameDao.findEntityById(id);
            game.setGenre(genreDao.findEntityById(game.getGenre().getId()));
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
        return game;
    }

    @Override
    public void delete(int id)  {
        Transaction transaction = transactionFactory.createTransaction();
        GameDao gameDao = daoFactory.createGameDao();
        transaction.begin(gameDao);
        try {
            gameDao.delete(id);
            transaction.commit();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();
    }

    @Override
    public void add(Game game)  {
        Transaction transaction = transactionFactory.createTransaction();
        GameDao gameDao = daoFactory.createGameDao();
        transaction.begin(gameDao);
        try {
            gameDao.create(game);
            transaction.rollback();
        }catch (DaoException e){
            transaction.rollback();
        }
        transaction.end();

    }
}
