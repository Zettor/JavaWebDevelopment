package by.yasenko.task2.controller.command.impl;

import by.yasenko.task2.controller.command.Command;
import by.yasenko.task2.service.MatrixService;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class FillLatch implements Command {

    private final Logger logger = LogManager.getLogger(FillLatch.class);

    @Override
    public String execute(final String request) {

        String  response = "Matrix filled.";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        try {
            matrixService.fillLatch();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            response = "There are some problems with filling with latch";
        }

        return response;

    }
}
