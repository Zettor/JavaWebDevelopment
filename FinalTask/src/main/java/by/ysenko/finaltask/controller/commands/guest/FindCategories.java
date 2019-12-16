package by.ysenko.finaltask.controller.commands.guest;

import by.ysenko.finaltask.bean.AccessoryCategory;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.AccessoryCategoryService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FindCategories extends GuestCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        AccessoryCategoryService service = ServiceFactory.createAccessoryCategoryService();
        List<AccessoryCategory> categories = null;
            categories = service.findAll();
        request.setAttribute("list",categories);
        return "/categories.jsp";
    }
}
