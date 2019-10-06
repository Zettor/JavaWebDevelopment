package by.yasenko.task2.controller.command.impl;

import by.yasenko.task2.controller.command.Command;
import by.yasenko.task2.service.MatrixService;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class InitMatrix implements Command {

    private final Logger logger = LogManager.getLogger(InitMatrix.class);

    @Override
    public String execute(final String request) {

        String[] tokens = request.split(" ");

        String response = "Matrix initialized.";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        try {
            matrixService.createMatrix(tokens[1]);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            response = "Wrong data!";
        }

        return response;
    }
}
