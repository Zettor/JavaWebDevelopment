package by.ysenko.finaltask.service.impl;

import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.*;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.dao.factories.impl.DaoFactoryImpl;
import by.ysenko.finaltask.dao.factories.impl.TransactionFactoryImpl;
import by.ysenko.finaltask.service.Service;
import by.ysenko.finaltask.service.TradeGameOfferService;

import java.util.List;

public class TradeGameOfferServiceImpl extends ServiceImpl implements TradeGameOfferService {

    @Override
    public List<TradeGameOffer> findLastOffers() throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        TradeGameOfferDao tradeGameOfferDao = daoFactory.createTradeGameOfferDao();
        GameDao gameDao = daoFactory.createGameDao();
        UserDao userDao = daoFactory.createUserDao();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(tradeGameOfferDao, gameDao, genreDao,userDao);
        List<TradeGameOffer> offers = tradeGameOfferDao.findAll();
        for (TradeGameOffer offer : offers) {
            offer.setGame(gameDao.findEntityById(offer.getGame().getId()));
            offer.getGame().setGenre(genreDao.findEntityById(offer.getGame().getId()));
            offer.setUser(userDao.findEntityById(offer.getUser().getId()));
        }
        transaction.end();
        if (offers.size() <= 5) {
            return offers;
        } else {
            return offers.subList(0, 4);
        }
    }

    @Override
    public List<TradeGameOffer> findOffers() throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        TradeGameOfferDao tradeGameOfferDao = daoFactory.createTradeGameOfferDao();
        GameDao gameDao = daoFactory.createGameDao();
        UserDao userDao = daoFactory.createUserDao();
        GenreDao genreDao = daoFactory.createGenreDao();
        transaction.begin(tradeGameOfferDao, gameDao, genreDao,userDao);
        List<TradeGameOffer> offers = tradeGameOfferDao.findAll();
        for (TradeGameOffer offer : offers) {
            offer.setGame(gameDao.findEntityById(offer.getGame().getId()));
            offer.getGame().setGenre(genreDao.findEntityById(offer.getGame().getId()));
            offer.setUser(userDao.findEntityById(offer.getUser().getId()));
        }
        transaction.end();
            return offers;
    }

    @Override
    public void add(TradeGameOffer offer) throws PersistentException {
        Transaction transaction = transactionFactory.createTransaction();
        TradeGameOfferDao offerDao = daoFactory.createTradeGameOfferDao();
        transaction.begin(offerDao);
        offerDao.create(offer);
        transaction.end();
    }
}
