package by.ysenko.finaltask.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToSettings implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/settings.jsp";
    }
}
