package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.AccessoryCategoryService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCategory extends AdminCommand {

    private final static String ID_ATTRIBUTE = "id";
    private final static String TO_HTML = "/categories.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt((String) request.getParameter(ID_ATTRIBUTE));
        AccessoryCategoryService service = ServiceFactory.createAccessoryCategoryService();
            service.delete(id);
        return TO_HTML;
    }
}
