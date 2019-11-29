package by.ysenko.finaltask.service.factories;

import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.service.TradeGameOfferService;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.impl.TradeGameOfferServiceImpl;
import by.ysenko.finaltask.service.impl.UserServiceImpl;

public abstract class ServiceFactory {

     public static UserService createUserService() {
      return new UserServiceImpl();
    }
    public static TradeGameOfferService createTradeGameOfferService() {
        return new TradeGameOfferServiceImpl();
    }
}
