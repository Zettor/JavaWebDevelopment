package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddGenre extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        Genre genre=new Genre();
        genre.setName((String)request.getParameter("genre"));
        GenreService service = ServiceFactory.createGenreService();

            service.add(genre);

        return "/genres.html";
    }
}
