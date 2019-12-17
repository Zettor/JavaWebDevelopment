package by.ysenko.finaltask.controller.commands.user;

import by.ysenko.finaltask.bean.Currency;
import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.controller.commands.UserCommand;
import by.ysenko.finaltask.service.CurrencyService;
import by.ysenko.finaltask.service.GameService;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ToAddingGameOffer extends UserCommand {

    private final static String ID_ATTRIBUTE = "id";
    private final static String GAME_ATTRIBUTE = "game";
    private final static String CURRENCIES_ATTRIBUTE = "currencies";
    private final static String TO_JSP = "add_game_offer.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt((String) request.getParameter(ID_ATTRIBUTE));
        GameService gameService = ServiceFactory.createGameService();
        CurrencyService currencyService = ServiceFactory.createCurrencyService();
        List<Currency> currencies = null;
            Game game = gameService.findById(id);
            currencies = currencyService.findAll();
            request.setAttribute(GAME_ATTRIBUTE, game);
            request.setAttribute(CURRENCIES_ATTRIBUTE,currencies);
        return TO_JSP;
    }
}
