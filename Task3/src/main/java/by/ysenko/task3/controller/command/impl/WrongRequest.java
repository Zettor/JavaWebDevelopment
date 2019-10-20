package by.ysenko.task3.controller.command.impl;


import by.ysenko.task3.controller.command.Command;

public final class WrongRequest implements Command {




    @Override
    public String execute(final String request) {
        return "wrong_request";
    }
}
