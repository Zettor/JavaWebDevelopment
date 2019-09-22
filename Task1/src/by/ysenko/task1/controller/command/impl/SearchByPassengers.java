package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

/**
 * SearchByPassengers is the class
 * that is used for calling searchByPassengers method.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class SearchByPassengers implements Command {

    /**
     * Method for calling method searchByPassengers(int start, int end)
     * from service layer.
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

        int start = Integer.parseInt(tokens[1]);
        int end = Integer.parseInt(tokens[2]);

        for (Car car : carService.searchByPassengers(start, end)) {
            response += car.toString() + "\n";
        }

        return response;
    }
}
