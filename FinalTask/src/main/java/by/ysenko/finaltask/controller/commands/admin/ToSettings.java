package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.controller.commands.AdminCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToSettings extends AdminCommand {

    private final static String TO_JSP = "/settings.jsp";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return TO_JSP;
    }
}
