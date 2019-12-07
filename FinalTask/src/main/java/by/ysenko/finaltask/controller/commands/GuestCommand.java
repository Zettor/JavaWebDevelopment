package by.ysenko.finaltask.controller.commands;

import java.util.ArrayList;
import java.util.List;

public abstract class GuestCommand implements Command{

    private List<Integer> roles;
   public GuestCommand(){
        roles=new ArrayList<>();
        roles=new ArrayList<>();        roles.add(0);
        roles.add(1);
        roles.add(null);
    }

    @Override
    public List<Integer> getRoles() {
        return roles;
    }
}
