package by.ysenko.finaltask.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Profile implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/profile.jsp";
    }
}
