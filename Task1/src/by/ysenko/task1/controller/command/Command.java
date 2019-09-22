package by.ysenko.task1.controller.command;

/**
 * Interface for different commands
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public interface Command {

    /**
     * Method of calling different methods of service layer.
     *
     * @param request - request from user.
     * @return response to user.
     */
    String execute(String request);
}
