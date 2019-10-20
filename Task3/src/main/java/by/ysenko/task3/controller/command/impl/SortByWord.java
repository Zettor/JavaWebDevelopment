package by.ysenko.task3.controller.command.impl;

import by.ysenko.task3.controller.command.Command;
import by.ysenko.task3.service.TextService;
import by.ysenko.task3.service.exception.ServiceException;
import by.ysenko.task3.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class SortByWord implements Command {

    /**
     * RootLogger for logging events.
     */
    private Logger Logger = LogManager.getRootLogger();

    @Override
    public String execute(final String request) {
        String response = "";
        String[] tokens = request.split(" ");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService matrixService = serviceFactory.getTextService();
        try {
            response = matrixService.sortByWord(tokens[1]);
        } catch (
                ServiceException e) {
            Logger.error(e.getMessage());
            response = "wrong_format";
        }

        return response;
    }
}
