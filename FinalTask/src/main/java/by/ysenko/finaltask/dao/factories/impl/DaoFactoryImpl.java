package by.ysenko.finaltask.dao.factories.impl;

import by.ysenko.finaltask.dao.*;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.dao.factories.DaoFactory;
import by.ysenko.finaltask.dao.impl.*;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public UserDao createUserDao() throws PersistentException {

        UserDao dao = new UserDaoImpl();
        return dao;
    }
    @Override
    public GameDao createGameDao() throws PersistentException {
        GameDao dao = new GameDaoImpl();
        return dao;
    }
    @Override
    public GenreDao createGenreDao() throws PersistentException {
        GenreDao dao = new GenreDaoImpl();
        return dao;
    }
    @Override
    public TradeGameOfferDao createTradeGameOfferDao() throws PersistentException {
        TradeGameOfferDao dao = new TradeGameOfferDaoImpl();
        return dao;
    }
    @Override
    public TradeConsoleOfferDao createTradeConsoleOfferDao() throws PersistentException {
        TradeConsoleOfferDao dao = new TradeConsoleOfferDaoImpl();
        return dao;
    }
    @Override
    public AccessoryCategoryDao createAccessoryCategoryDao() throws PersistentException {
        AccessoryCategoryDao dao = new AccessoryCategoryDaoImpl();
        return dao;
    }
    @Override
    public ExchangeGameOfferDao createExchangeGameOfferDao() throws PersistentException {
        ExchangeGameOfferDao dao = new ExchangeGameOfferDaoImpl();
        return dao;
    }

    @Override
    public CurrencyDao createCurrencyDao() throws PersistentException {
        CurrencyDao dao = new CurrencyDaoImpl();
        return dao;
    }
}
