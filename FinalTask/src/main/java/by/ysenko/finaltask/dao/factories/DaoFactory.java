package by.ysenko.finaltask.dao.factories;

import by.ysenko.finaltask.dao.*;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.dao.impl.*;

public interface DaoFactory  {

    public UserDao createUserDao() throws PersistentException;

    public GameDao createGameDao() throws PersistentException ;

    public GenreDao createGenreDao() throws PersistentException ;

    public TradeGameOfferDao createTradeGameOfferDao() throws PersistentException ;

    public TradeConsoleOfferDao createTradeConsoleOfferDao() throws PersistentException ;

    public AccessoryCategoryDao createAccessoryCategoryDao() throws PersistentException ;

    public ExchangeGameOfferDao createExchangeGameOfferDao() throws PersistentException ;
}
