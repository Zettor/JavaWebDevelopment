package by.ysenko.finaltask.dao.factories;

import by.ysenko.finaltask.dao.*;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.dao.impl.*;

public interface DaoFactory  {

    public UserDao createUserDao() ;

    public GameDao createGameDao() ;

    public GenreDao createGenreDao() ;

    public TradeGameOfferDao createTradeGameOfferDao() ;

    public TradeConsoleOfferDao createTradeConsoleOfferDao() ;

    public AccessoryCategoryDao createAccessoryCategoryDao() ;

    public CurrencyDao createCurrencyDao() ;

    public CountryDao createCountryDao() ;

    public CityDao createCityDao() ;
}
