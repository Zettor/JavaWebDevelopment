package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindGenres extends GuestCommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        GenreService service = ServiceFactory.createGenreService();
        List<Genre> genres = null;
        try {
            genres = service.findAll();
        } catch (PersistentException e) {
            //log
        }
        request.setAttribute("list",genres);
        return "/genres.jsp";
    }
}
