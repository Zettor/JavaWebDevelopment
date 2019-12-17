package by.ysenko.finaltask.dao.factories.impl;

import by.ysenko.finaltask.dao.*;

import by.ysenko.finaltask.dao.factories.DaoFactory;
import by.ysenko.finaltask.dao.impl.*;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public UserDao createUserDao()  {

        UserDao dao = new UserDaoImpl();
        return dao;
    }
    @Override
    public GameDao createGameDao()  {
        GameDao dao = new GameDaoImpl();
        return dao;
    }
    @Override
    public GenreDao createGenreDao()  {
        GenreDao dao = new GenreDaoImpl();
        return dao;
    }
    @Override
    public TradeGameOfferDao createTradeGameOfferDao()  {
        TradeGameOfferDao dao = new TradeGameOfferDaoImpl();
        return dao;
    }
    @Override
    public TradeConsoleOfferDao createTradeConsoleOfferDao()  {
        TradeConsoleOfferDao dao = new TradeConsoleOfferDaoImpl();
        return dao;
    }
    @Override
    public AccessoryCategoryDao createAccessoryCategoryDao()  {
        AccessoryCategoryDao dao = new AccessoryCategoryDaoImpl();
        return dao;
    }


    @Override
    public CurrencyDao createCurrencyDao()  {
        CurrencyDao dao = new CurrencyDaoImpl();
        return dao;
    }
    @Override
    public CountryDao createCountryDao()  {
        CountryDao dao = new CountryDaoImpl();
        return dao;
    }

    @Override
    public CityDao createCityDao()  {
        CityDao dao = new CityDaoImpl();
        return dao;
    }
}
