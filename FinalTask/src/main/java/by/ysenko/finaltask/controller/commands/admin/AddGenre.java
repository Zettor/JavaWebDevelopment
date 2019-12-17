package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddGenre extends AdminCommand {
    private final static String GENRE_ATTRIBUTE = "genre";
    private final static String TO_HTML = "/genres.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        Genre genre=new Genre();
        genre.setName((String)request.getParameter(GENRE_ATTRIBUTE));
        GenreService service = ServiceFactory.createGenreService();

            service.add(genre);

        return TO_HTML;
    }
}
