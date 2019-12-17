package by.ysenko.finaltask.controller.commands.guest;


import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.service.TradeGameOfferService;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ToGameOffer extends GuestCommand {

    private final static String OFFER_ATTRIBUTE = "offer";
    private final static String TO_JSP = "game_offer.jsp";


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt((String) request.getParameter("id"));
        TradeGameOfferService offerService = ServiceFactory.createTradeGameOfferService();

            TradeGameOffer offer = offerService.findById(id);
            request.setAttribute(OFFER_ATTRIBUTE, offer);

        return TO_JSP;
    }
}
