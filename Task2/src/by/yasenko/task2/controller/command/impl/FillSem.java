package by.yasenko.task2.controller.command.impl;

import by.yasenko.task2.controller.command.Command;
import by.yasenko.task2.service.MatrixService;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class FillSem implements Command {

    private final Logger logger = LogManager.getLogger(FillSem.class);

    @Override
    public String execute(final String request) {

        String[] tokens = request.split(" ");


        String response = "Matrix filled.";
        try {
            int permits = Integer.valueOf(tokens[1]);

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            MatrixService matrixService = serviceFactory.getMatrixService();

            try {
                matrixService.fillSem(permits);
            } catch (ServiceException e) {
                logger.error(e.getMessage());
                response = "Wrong number of permits.";
            }
        } catch (NumberFormatException e) {
            logger.error("fillSem got date of wrong format");
            response = "Not a number";
        }

        return response;
}
}
