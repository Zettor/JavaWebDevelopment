package by.ysenko.finaltask.controller.commands.user;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.UserCommand;
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
        if (request.getParameter("country") != null && !request.getParameter("country").isEmpty()) {
            user.getCountry().setId(Integer.parseInt(request.getParameter("country")));
            session.setAttribute("country_id", request.getParameter("country"));
        }
        if (request.getParameter("city") != null && !request.getParameter("city").isEmpty()) {
            System.out.println(request.getParameter("city"));
            user.getCity().setId(Integer.parseInt(request.getParameter("city")));
        }
        user.setPhone(request.getParameter("phone"));


            service.editUser(user);
            session.removeAttribute("user");
            session.setAttribute("user", user);

        if (request.getParameter("save")!=null) {
            return "/profile.html";
        } else {
            return "/to_edit_profile.html";
        }
    }
}
