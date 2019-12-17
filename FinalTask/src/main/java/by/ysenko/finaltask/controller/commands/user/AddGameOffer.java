package by.ysenko.finaltask.controller.commands.user;

import by.ysenko.finaltask.bean.*;
import by.ysenko.finaltask.controller.commands.UserCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GameService;
import by.ysenko.finaltask.service.TradeGameOfferService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class AddGameOffer extends UserCommand {

    private final static String GAME_ID_ATTRIBUTE = "game_id";
    private final static String GENRE_ID_ATTRIBUTE = "genre_id";
    private final static String COST_ATTRIBUTE = "cost";
    private final static String CURRENCY_ATTRIBUTE = "currency";
    private final static String DESCRIPTION_ATTRIBUTE = "description";
    private final static String USER_ATTRIBUTE = "user";
    private final static String TO_HTML = "/profile.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TradeGameOffer offer = new TradeGameOffer();
        HttpSession session = request.getSession(false);
        offer.setUser((User) session.getAttribute(USER_ATTRIBUTE));
        offer.setGame(new Game());
        offer.getGame().setId(Integer.parseInt(request.getParameter(GAME_ID_ATTRIBUTE)));
        Genre genre = new Genre();
        genre.setId(Integer.parseInt(request.getParameter(GENRE_ID_ATTRIBUTE)));
        offer.getGame().setGenre(genre);
        offer.setCost(Double.parseDouble(request.getParameter(COST_ATTRIBUTE)));
        offer.setCurrency(new Currency());
        offer.getCurrency().setId(Integer.parseInt(request.getParameter(CURRENCY_ATTRIBUTE)));
        offer.setDescription(request.getParameter(DESCRIPTION_ATTRIBUTE));;
        offer.setCreateDate(new Timestamp(new Date().getTime()));
        offer.setStatus(0);
        TradeGameOfferService service = ServiceFactory.createTradeGameOfferService();
            service.add(offer);
        return TO_HTML;
    }


}
