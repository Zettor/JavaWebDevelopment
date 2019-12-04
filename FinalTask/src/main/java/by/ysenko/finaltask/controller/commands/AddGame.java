package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GameService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

public class AddGame extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Game game = new Game();
        game.setName((String) request.getParameter("name"));
        game.setGenre(new Genre());
        game.getGenre().setId(Integer.parseInt((String) request.getParameter("genre")));
        game.setExclusivity(Integer.parseInt((String) request.getParameter("exclusivity")));
        game.setReleaseDate(Timestamp.valueOf((String) request.getParameter("date")+" 00:00:00.0"));
        game.setDescription((String) request.getParameter("description"));
        GameService service = ServiceFactory.createGameService();
        try {
            service.add(game);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return "/games.html";
    }
}
