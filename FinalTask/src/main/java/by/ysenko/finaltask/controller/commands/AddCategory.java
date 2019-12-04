package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.bean.AccessoryCategory;
import by.ysenko.finaltask.bean.Genre;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.AccessoryCategoryService;
import by.ysenko.finaltask.service.GenreService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCategory extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        AccessoryCategory category=new AccessoryCategory();
        category.setName((String)request.getParameter("category"));
        AccessoryCategoryService service = ServiceFactory.createAccessoryCategoryService();
        try {
            service.add(category);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return "/categories.html";
    }
}
