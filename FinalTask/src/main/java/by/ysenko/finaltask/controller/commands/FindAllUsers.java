package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.Service;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class FindAllUsers implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = ServiceFactory.createUserService();
        List<User> users = null;
        try {
            users = service.findAll();
        } catch (PersistentException e) {
            //log
        }
        request.setAttribute("list", users);
        return "/result.jsp";
    }
}
