package by.ysenko.task3.controller.command.impl;


import by.ysenko.task3.controller.command.Command;
import by.ysenko.task3.service.TextService;
import by.ysenko.task3.service.factory.ServiceFactory;

import java.util.ResourceBundle;


public final class GetText implements Command {


    @Override
    public String execute(final String request, ResourceBundle rb) {
        String response = "";

        String[] tokens = request.split(" ");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService matrixService = serviceFactory.getMatrixService();

        int index = Integer.parseInt(tokens[1]);

        response = matrixService.getText(index);

        return response;
    }
}
