package by.ysenko.task3.controller.command.impl;


import by.ysenko.task3.controller.command.Command;
import by.ysenko.task3.service.TextService;
import by.ysenko.task3.service.exception.ServiceException;
import by.ysenko.task3.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class ReadText implements Command {

    /**
     * RootLogger for logging events.
     */
    private final Logger logger = LogManager.getLogger(ReadText.class);

    @Override
    public String execute(final String request) {

        String[] tokens = request.split(" ");

        String response = "finish_read";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TextService textService = serviceFactory.getTextService();

        try {
            textService.readText(tokens[1], tokens[2]);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            response = "wrong_path";
        }

        return response;
    }
}
