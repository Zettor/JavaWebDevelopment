package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.exception.ServiceException;
import by.ysenko.task1.service.factory.ServiceFactory;

/**
 * AddCars is the class that is used for calling addCars method.
 * @author Alexander Ysenko
 * @version 1.0
 */
public class AddCars implements Command {

    /**
     * Path to file with data in String.
     */
    private final static String PATH_TO_FILE = "D:\\Курсы\\"
            + "JavaWebDvelopment\\Task1\\src\\data\\input.txt";

    /**
     * Method for calling method addCars(String path) from service layer.
     *
     * @param request - request from user.
     * @return response to user.
     */
    @Override
    public String execute(final String request) {

        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        try {
            carService.addCars(PATH_TO_FILE);
            response = "Cars add to train.";
        } catch (ServiceException e) {
            response = e.getMessage();
        }

        return response;
    }
}
