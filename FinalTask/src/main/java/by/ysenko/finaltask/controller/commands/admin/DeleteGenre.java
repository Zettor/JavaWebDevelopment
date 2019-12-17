package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteGenre extends AdminCommand {

    private final static String ID_ATTRIBUTE = "id";
    private final static String TO_HTML = "/games.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt((String) request.getParameter(ID_ATTRIBUTE));
        GenreService service = ServiceFactory.createGenreService();
            service.delete(id);
        return TO_HTML;
    }
}
