package by.ysenko.finaltask.controller.commands.user;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.controller.commands.UserCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.CurrencyService;
import by.ysenko.finaltask.service.GameService;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ToAddingGameOffer extends UserCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt((String) request.getParameter("id"));
        GameService gameService = ServiceFactory.createGameService();
        CurrencyService currencyService = ServiceFactory.createCurrencyService();
        List<Currency> currencies = null;
        try {
            Game game = gameService.findById(id);
            currencies = currencyService.findAll();
            request.setAttribute("game", game);
            request.setAttribute("currencies",currencies);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return "add_game_offer.jsp";
    }
}
