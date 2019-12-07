package by.ysenko.finaltask.controller.commands.guest;

import by.ysenko.finaltask.bean.User;
import by.ysenko.finaltask.controller.commands.GuestCommand;
import by.ysenko.finaltask.dao.exception.PersistentException;
import by.ysenko.finaltask.service.UserService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToProfile extends GuestCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id=null;

        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }else{
            HttpSession session = request.getSession(false);
            id = ((User)session.getAttribute("user")).getId();

        }
        UserService service = ServiceFactory.createUserService();
        System.out.println(request.getParameter("id"));
        try {
            User user = service.findById(id);
            request.setAttribute("user",user  );
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return "/profile.jsp";
    }
}
