package by.ysenko.finaltask.controller.commands.guest;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.bean.TradeGameOffer;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GameService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.TradeGameOfferService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindGameOffers extends GuestCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TradeGameOfferService service = ServiceFactory.createTradeGameOfferService();
        List<TradeGameOffer> offers = null;
        try {
            offers = service.findOffers();
        } catch (PersistentException e) {
            //log
        }
        request.setAttribute("offers", offers);
        return "/game_offers.jsp";
    }
}
