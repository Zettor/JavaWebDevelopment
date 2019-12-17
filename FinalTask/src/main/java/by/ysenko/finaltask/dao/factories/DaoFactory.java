package by.ysenko.finaltask.dao.factories;

import by.ysenko.finaltask.dao.*;


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
