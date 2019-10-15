package by.ysenko.task3.controller.command.impl;


import by.ysenko.task3.controller.command.Command;

import java.util.ResourceBundle;

public final class WrongRequest implements Command {




    @Override
    public String execute(final String request, ResourceBundle rb) {
        return rb.getString("wrong_request");
    }
}
