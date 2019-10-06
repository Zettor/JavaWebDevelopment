package by.yasenko.task2.controller.command;


public interface Command {

    /**
     * Method of calling different methods of service layer.
     *
     * @param request - request from user.
     * @return response to user.
     */
    String execute(String request);
}
