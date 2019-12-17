package by.ysenko.finaltask.controller.commands.admin;

import by.ysenko.finaltask.controller.commands.AdminCommand;
import by.ysenko.finaltask.service.CurrencyService;
import by.ysenko.finaltask.service.factories.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCurrency extends AdminCommand {

    private final static String ID_ATTRIBUTE = "id";
    private final static String TO_HTML = "/currencies.html";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.parseInt((String) request.getParameter(ID_ATTRIBUTE));
        CurrencyService service = ServiceFactory.createCurrencyService();
            service.delete(id);
        return TO_HTML;
    }
}
