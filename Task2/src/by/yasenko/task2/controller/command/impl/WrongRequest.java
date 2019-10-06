package by.yasenko.task2.controller.command.impl;

import by.yasenko.task2.controller.command.Command;


public final class WrongRequest implements Command {

    /**
     * Warning message.
     */
    private final static String WARNING_MSG = "Wrong request!";


    @Override
    public String execute(final String request) {
        return WARNING_MSG;
    }
}
