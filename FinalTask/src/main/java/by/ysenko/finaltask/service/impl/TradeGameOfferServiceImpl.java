package by.ysenko.finaltask.service.impl;


import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.dao.*;
import by.ysenko.finaltask.dao.exception.DaoException;
import by.ysenko.finaltask.service.TradeGameOfferService;

import java.util.List;

public class TradeGameOfferServiceImpl extends ServiceImpl implements TradeGameOfferService {

    @Override
    public List<TradeGameOffer> findLastOffers()  {
        Transaction transaction = transactionFactory.createTransaction();
        TradeGameOfferDao tradeGameOfferDao = daoFactory.createTradeGameOfferDao();
        GameDao gameDao = daoFactory.createGameDao();
        UserDao userDao = daoFactory.createUserDao();
        GenreDao genreDao = daoFactory.createGenreDao();
        CurrencyDao currencyDao = daoFactory.createCurrencyDao();
        transaction.begin(tradeGameOfferDao, gameDao, genreDao, userDao, currencyDao);
        List<TradeGameOffer> offers = null;
        try {
            offers = tradeGameOfferDao.findLastOffers();
            for (TradeGameOffer offer : offers) {
                offer.setGame(gameDao.findEntityById(offer.getGame().getId()));
                offer.getGame().setGenre(genreDao.findEntityById(offer.getGame().getId()));
                offer.setCurrency(currencyDao.findEntityById(offer.getCurrency().getId()));
                offer.setUser(userDao.findEntityById(offer.getUser().getId()));
                transaction.commit();
            }
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
        return offers;
    }

    @Override
    public List<TradeGameOffer> findOffers()  {
        Transaction transaction = transactionFactory.createTransaction();
        TradeGameOfferDao tradeGameOfferDao = daoFactory.createTradeGameOfferDao();
        GameDao gameDao = daoFactory.createGameDao();
        UserDao userDao = daoFactory.createUserDao();
        GenreDao genreDao = daoFactory.createGenreDao();
        CurrencyDao currencyDao = daoFactory.createCurrencyDao();
        transaction.begin(tradeGameOfferDao, gameDao, genreDao, userDao, currencyDao);
        List<TradeGameOffer> offers = null;
        try {
            offers = tradeGameOfferDao.findAll();
            for (TradeGameOffer offer : offers) {
                offer.setGame(gameDao.findEntityById(offer.getGame().getId()));
                offer.getGame().setGenre(genreDao.findEntityById(offer.getGame().getId()));
                offer.setCurrency(currencyDao.findEntityById(offer.getCurrency().getId()));
                offer.setUser(userDao.findEntityById(offer.getUser().getId()));
                transaction.commit();
            }
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
        return offers;
    }

    @Override
    public void add(TradeGameOffer offer)  {
        Transaction transaction = transactionFactory.createTransaction();
        TradeGameOfferDao offerDao = daoFactory.createTradeGameOfferDao();
        transaction.begin(offerDao);
        try {
            offerDao.create(offer);
            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
        }
        transaction.end();
    }

    @Override
    public TradeGameOffer findById(Integer id)  {
        Transaction transaction = transactionFactory.createTransaction();
        TradeGameOfferDao offerDao = daoFactory.createTradeGameOfferDao();
        GameDao gameDao = daoFactory.createGameDao();
        UserDao userDao = daoFactory.createUserDao();
        GenreDao genreDao = daoFactory.createGenreDao();
        CurrencyDao currencyDao = daoFactory.createCurrencyDao();
        transaction.begin(offerDao, gameDao, genreDao, userDao, currencyDao);
        TradeGameOffer offer = null;
        try {
            offer = offerDao.findEntityById(id);
            offer.setGame(gameDao.findEntityById(offer.getGame().getId()));
            offer.setUser(userDao.findEntityById(offer.getUser().getId()));
            offer.setCurrency(currencyDao.findEntityById(offer.getCurrency().getId()));
            Game game = offer.getGame();
            game.setGenre(genreDao.findEntityById(game.getGenre().getId()));
            transaction.commit();
        } catch (DaoException e) {
            transaction.commit();
        }
        transaction.end();
        return offer;
    }
}
