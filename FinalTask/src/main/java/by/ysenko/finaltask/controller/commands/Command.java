package by.ysenko.finaltask.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public interface Command {

String execute (HttpServletRequest request, HttpServletResponse response);

 List<Integer> getRoles();
}