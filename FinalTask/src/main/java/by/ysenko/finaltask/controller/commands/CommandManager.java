package by.ysenko.finaltask.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandManager {

    private String command;

    public void setCommand(String command) {
        this.command = command;

    }

    public String getCommand() {
        return command;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String temp = null;

        switch (command) {
            case "/":
                temp = new FindLastOffers().execute(request, response);
                break;
            case"/sign_up":
                temp =new SignUp().execute(request,response);
                break;
            case"/sign_in":
                temp =new SignIn().execute(request,response);
                break;
            case"/profile":
                temp =new Profile().execute(request,response);
                break;
            case"/logout":
                temp =new Logout().execute(request,response);
                break;
            case"/edit_profile":
                temp =new EditProfile().execute(request,response);
                break;
            case"/settings":
                temp =new ToSettings().execute(request,response);
                break;
            default:


        }

        return temp;
    }
}