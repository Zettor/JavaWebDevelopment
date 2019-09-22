package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;


/**
 * SumOfSpeed is the class that is used for returning warning message to user. .
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class WrongRequest implements Command {

    /**
     * Warning message.
     */
    private final static String WARNING_MSG = "Wrong request!";

    /**
     * Method for returning warning message to user.
     *
     * @param request - wrong request from user.
     * @return warning response to user.
     */
    @Override
    public String execute(final String request) {
        return WARNING_MSG;
    }
}
