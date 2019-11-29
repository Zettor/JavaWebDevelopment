package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class SignUp implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = ServiceFactory.createUserService();
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setCreateDate(new Timestamp(new Date().getTime()));
        user.setRole(0);
        user.setStatus(0);

        try {
            service.signUp(user);
            HttpSession session = request.getSession(false);
            session.setAttribute("user" , user);
        } catch (PersistentException e) {
            System.out.println(e.getMessage());
        }
        return "/.html";
    }
}
