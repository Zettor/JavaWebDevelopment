package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

/**
 * SortByName is the class that is used for calling sortByName method.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class SortByName implements Command {

    /**
     * Method for calling method sortByName from service layer.
     *
     * @param request - request from user.
     * @return response to user.
     */
    @Override
    public String execute(final String request) {
        String response = "";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        for (Car car : carService.sortByName()) {
            response += car.toString() + "\n";
        }

        return response;
    }
}
