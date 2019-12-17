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

    private final static String USER_ATTRIBUTE = "user";
    private final static String COUNTRY_ATTRIBUTE = "country";
    private final static String CITY_ATTRIBUTE = "city";
    private final static String PHONE_ATTRIBUTE = "phone";

    private final static String COUNTRY_ID_ATTRIBUTE = "country_id";
    private final static String TO_HTML = "/profile.html";
    private final static String TO_EDIT_HTML = "/to_edit_profile.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        UserService service = ServiceFactory.createUserService();
        HttpSession session = request.getSession(false);

        User user = (User) session.getAttribute(USER_ATTRIBUTE);
        if (request.getParameter(COUNTRY_ATTRIBUTE) != null && !request.getParameter("country").isEmpty()) {
            user.getCountry().setId(Integer.parseInt(request.getParameter(COUNTRY_ATTRIBUTE)));
            session.setAttribute(COUNTRY_ID_ATTRIBUTE, request.getParameter(COUNTRY_ATTRIBUTE));
        }
        if (request.getParameter(CITY_ATTRIBUTE) != null && !request.getParameter(CITY_ATTRIBUTE).isEmpty()) {
            System.out.println(request.getParameter(CITY_ATTRIBUTE));
            user.getCity().setId(Integer.parseInt(request.getParameter(CITY_ATTRIBUTE)));
        }
        user.setPhone(request.getParameter(PHONE_ATTRIBUTE));


            service.editUser(user);
            session.removeAttribute(USER_ATTRIBUTE);
            session.setAttribute(USER_ATTRIBUTE, user);

        if (request.getParameter("save")!=null) {
            return TO_HTML;
        } else {
            return TO_EDIT_HTML;
        }
    }
}
