package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;

public class WrongRequest implements Command {
    @Override
    public String execute(String request) {
        return "Wrong request!";
    }
}
