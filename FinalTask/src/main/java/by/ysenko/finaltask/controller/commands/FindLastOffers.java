package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.TradeGameOfferService;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindLastOffers extends GuestCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TradeGameOfferService service = ServiceFactory.createTradeGameOfferService();
        List<TradeGameOffer> offers = null;
        try {
            offers = service.findLastOffers();
        } catch (PersistentException e) {
            //log
        }
        request.setAttribute("list", offers);
        return "/result.jsp";
    }
}
