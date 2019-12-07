package by.ysenko.finaltask.controller.commands.user;

import by.ysenko.finaltask.controller.commands.UserCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Profile extends UserCommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/edit_profile.jsp";
    }
}
