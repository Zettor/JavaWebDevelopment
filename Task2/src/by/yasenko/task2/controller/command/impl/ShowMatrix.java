package by.yasenko.task2.controller.command.impl;

import by.yasenko.task2.controller.command.Command;
import by.yasenko.task2.service.MatrixService;
import by.yasenko.task2.service.factory.ServiceFactory;


public final class ShowMatrix implements Command {


    @Override
    public String execute(final String request) {
        String response = "";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        response = matrixService.showMatrix();

        return response;
    }
}
