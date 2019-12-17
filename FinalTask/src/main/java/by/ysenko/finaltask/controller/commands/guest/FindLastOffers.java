package by.ysenko.finaltask.controller.commands.guest;

import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.TradeGameOfferService;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindLastOffers extends GuestCommand {

    private final static String LIST_ATTRIBUTE = "list";
    private final static String TO_JSP = "result.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        TradeGameOfferService service = ServiceFactory.createTradeGameOfferService();
        List<TradeGameOffer> offers = null;


            offers = service.findLastOffers();

        request.setAttribute(LIST_ATTRIBUTE, offers);
        return TO_JSP;
    }
}
