package by.ysenko.finaltask.controller.commands.user;

import by.ysenko.finaltask.bean.Game;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.UserCommand;
import by.ysenko.finaltask.service.GameService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ChooseGame extends UserCommand {

    private final static String LIST_ATTRIBUTE = "list";
    private final static String GENRES_ATTRIBUTE = "genres";
    private final static String TO_JSP = "/user_games.jsp";

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

        request.setAttribute(LIST_ATTRIBUTE,games);
        request.setAttribute(GENRES_ATTRIBUTE,genres);
        return TO_JSP;
    }
}
