package by.ysenko.finaltask.controller.commands;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

abstract public class Command {

abstract public   String execute (HttpServletRequest request, HttpServletResponse response);

 public abstract  List<Integer> getRoles();

 protected ResourceBundle getLocale(HttpServletRequest request) {
  String localeCountry = null;
  String localeLanguage = null;
  Cookie[] cookies = request.getCookies();
  String locale = null;
  for (int i = 0; i < cookies.length; i++) {
   if (cookies[i].getName().equals("lang")) {
    locale = cookies[i].getValue();
   }
  }
  Locale current = new Locale(locale);
  return ResourceBundle.getBundle("text", current);
 }
}
