package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

/**
 * SearchByWeight is the class
 * that is used for calling searchByWeight method.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class SearchByWeight implements Command {

    /**
     * Method for calling method
     * searchByWeight(double start, double end) from service layer.
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

        double start = Double.parseDouble(tokens[1]);

        double end = Double.parseDouble(tokens[2]);

        for (Car car : carService.searchByWeight(start, end)) {
            response += car.toString() + "\n";
        }

        return response;

    }
}
