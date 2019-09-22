package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

/**
 * SumOfPassengers is the class
 * that is used for calling calcSumOfPassengers method.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class SumOfPassengers implements Command {

    /**
     * Method for calling method calcSumOfPassengers() from service layer.
     *
     * @param request - request from user.
     * @return response to user.
     */
    @Override
    public String execute(final String request) {
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        double sumOfPassengers = carService.calcSumOfPassengers();

        response = "Sum of baggage " + sumOfPassengers;

        return response;
    }
}
