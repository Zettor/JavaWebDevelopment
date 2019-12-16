package by.ysenko.finaltask.service.factories;

import by.ysenko.finaltask.bean.AccessoryCategory;
import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.service.*;
import by.ysenko.finaltask.service.impl.*;

public abstract class ServiceFactory {

    public static UserService createUserService() {
        return new UserServiceImpl();
    }

    public static GenreService createGenreService() {
        return new GenreServiceImpl();
    }

    public static CurrencyService createCurrencyService() {
        return new CurrencyServiceImpl();
    }

    public static TradeGameOfferService createTradeGameOfferService() {
        return new TradeGameOfferServiceImpl();
    }

    public static AccessoryCategoryService createAccessoryCategoryService() {
        return new AccessoryCategoryServiceImpl();
    }

    public static GameService createGameService() {
        return new GameServiceImpl();
    }

    public static CountryService createCountryService() {
        return new CountryServiceImpl();
    }

    public static CityService createCityService() {
        return new CityServiceImpl();
    }
    public static ConnectionService createConnectionService() {
        return new ConnectionServiceImpl();
    }
}
