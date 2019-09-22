package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

/**
 * SumOfSpeed is the class that is used for calling calcSumOfSpeed method.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class SumOfSpeed implements Command {

    /**
     * Method for calling method calcSumOfSpeed() from service layer.
     *
     * @param request - request from user.
     * @return response to user.
     */
    @Override
    public String execute(String request) {
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        double sumOfSpeed = carService.calcSumOfSpeed();

        response = "Sum of speed " + sumOfSpeed;

        return response;
    }
}
