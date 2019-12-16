package by.ysenko.finaltask.controller.commands.admin;


import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetUserRole extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = ServiceFactory.createUserService();


        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer role = Integer.parseInt(request.getParameter("role"));

            service.setRole(id, role);


        return "/users.html";

    }
}
