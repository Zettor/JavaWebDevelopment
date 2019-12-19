package by.ysenko.finaltask.controller.commands;

import java.util.ArrayList;
import java.util.List;

public abstract class AdminCommand extends Command {

    private List<Integer> roles;

 public    AdminCommand() {

        roles = new ArrayList<>();
        roles.add(1);
    }

    @Override
    public List<Integer> getRoles() {
        return roles;
    }
}
