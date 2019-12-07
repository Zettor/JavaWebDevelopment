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
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TradeGameOffer offer = new TradeGameOffer();
        HttpSession session = request.getSession(false);
        offer.setUser((User) session.getAttribute("user"));
        offer.setGame(new Game());
        offer.getGame().setId(Integer.parseInt(request.getParameter("game_id")));
        Genre genre = new Genre();
        genre.setId(Integer.parseInt(request.getParameter("genre_id")));
        offer.getGame().setGenre(genre);
        offer.setCost(Double.parseDouble(request.getParameter("cost")));
        offer.setCurrency(new Currency());
        offer.getCurrency().setId(Integer.parseInt(request.getParameter("currency")));
        offer.setDescription(request.getParameter("description"));;
        offer.setCreateDate(new Timestamp(new Date().getTime()));
        offer.setStatus(0);
        TradeGameOfferService service = ServiceFactory.createTradeGameOfferService();
        try {
            service.add(offer);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return "/profile.html";
    }


}
