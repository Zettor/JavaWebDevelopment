package by.ysenko.finaltask.controller.commands.user;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.UserCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GameService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChooseGame extends UserCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        GameService gameService = ServiceFactory.createGameService();
        List<Game> games = null;
        GenreService genreService = ServiceFactory.createGenreService();
        List<Genre> genres = null;
            games = gameService.findAll();
            for(Game game: games){
                System.out.println(game.getImgPath());
            }
            genres = genreService.findAll();

        request.setAttribute("list",games);
        request.setAttribute("genres",genres);
        return "/user_games.jsp";
    }
}
