package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.bean.AccessoryCategory;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.AccessoryCategoryService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCategory extends AdminCommand {

    private final static String CATEGORY_ATTRIBUTE="category";
    private final static String TO_HTML="/categories.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        AccessoryCategory category=new AccessoryCategory();
        category.setName((String)request.getParameter(CATEGORY_ATTRIBUTE));
        AccessoryCategoryService service = ServiceFactory.createAccessoryCategoryService();
            service.add(category);
        return TO_HTML;
    }
}
