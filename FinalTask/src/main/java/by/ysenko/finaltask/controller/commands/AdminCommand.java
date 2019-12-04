package by.ysenko.finaltask.controller.commands;

import java.util.ArrayList;
import java.util.List;

abstract class AdminCommand implements Command {

    private List<Integer> roles;

    AdminCommand() {

        roles = new ArrayList<>();
        roles.add(1);
    }

    @Override
    public List<Integer> getRoles() {
        return roles;
    }
}
