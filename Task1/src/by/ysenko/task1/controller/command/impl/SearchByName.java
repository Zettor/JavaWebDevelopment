package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

/**
 * SearchByName is the class that is used for calling searchByName method.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class SearchByName implements Command {

    /**
     * Method for calling method searchByName(String name) from service layer.
     *
     * @param request - request from user.
     * @return response to user.
     */
    @Override
    public String execute(final String request) {

        String[] tokens = request.split(" ");

        String response = "";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        for (Car car : carService.searchByName(tokens[1])) {
            response += car.toString() + "\n";
        }

        return response;
    }
}
