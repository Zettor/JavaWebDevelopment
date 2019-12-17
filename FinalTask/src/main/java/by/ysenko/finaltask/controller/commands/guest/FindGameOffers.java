package by.ysenko.finaltask.controller.commands.guest;

import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.service.TradeGameOfferService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindGameOffers extends GuestCommand {

    private final static String OFFERS_ATTRIBUTE = "offers";
    private final static String TO_JSP = "/game_offers.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TradeGameOfferService service = ServiceFactory.createTradeGameOfferService();
        List<TradeGameOffer> offers = null;

            offers = service.findOffers();
        request.setAttribute(OFFERS_ATTRIBUTE, offers);
        return TO_JSP;
    }
}
