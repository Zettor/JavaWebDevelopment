package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindGenres extends AdminCommand {

    private final static String LIST_ATTRIBUTE = "list";
    private final static String TO_JSP = "/genres.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        GenreService service = ServiceFactory.createGenreService();
        List<Genre> genres = null;

            genres = service.findAll();

        request.setAttribute(LIST_ATTRIBUTE,genres);
        return TO_JSP;
    }
}
