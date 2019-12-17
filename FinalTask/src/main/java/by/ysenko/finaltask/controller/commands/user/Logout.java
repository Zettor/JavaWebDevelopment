package by.ysenko.finaltask.controller.commands.user;

import by.ysenko.finaltask.controller.commands.UserCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends UserCommand {
    private final static String TO_HTML = "/.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession(false);
        session.invalidate();

        return TO_HTML;
    }
}
