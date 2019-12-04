package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteGenre extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt((String) request.getParameter("id"));
        GenreService service = ServiceFactory.createGenreService();
        try {
            service.delete(id);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return "/genres.html";
    }
}
