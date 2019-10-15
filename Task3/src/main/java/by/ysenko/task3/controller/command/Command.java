package by.ysenko.task3.controller.command;


import java.util.ResourceBundle;

public interface Command {

    /**
     * Method of calling different methods of service layer.
     *
     * @param request - request from user.
     * @return response to user.
     */
    String execute(String request, ResourceBundle rb);
}
