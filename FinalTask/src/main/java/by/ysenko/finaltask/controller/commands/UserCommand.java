package by.ysenko.finaltask.controller.commands;

import java.util.ArrayList;
import java.util.List;

public abstract class UserCommand implements Command {
    private List<Integer> roles;
   public UserCommand(){
        roles=new ArrayList<>();
        roles.add(0);
        roles.add(1);

    }

    @Override
    public List<Integer> getRoles() {
        return roles;
    }
}
