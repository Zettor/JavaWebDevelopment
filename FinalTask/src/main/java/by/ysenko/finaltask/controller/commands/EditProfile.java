package by.ysenko.finaltask.controller.commands;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

public class EditProfile extends UserCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = ServiceFactory.createUserService();
        HttpSession session = request.getSession(false);

        User user = (User) session.getAttribute("user");
        user.setCountry(request.getParameter("country"));
        user.setState(request.getParameter("state"));
        user.setCity(request.getParameter("city"));
        user.setPhone(request.getParameter("phone"));
        try {
            service.editUser(user);
            session.removeAttribute("user");
            session.setAttribute("user", user);
        } catch (PersistentException e) {
            System.out.println(e.getMessage());
        }
        return "/profile.html";
    }
}
