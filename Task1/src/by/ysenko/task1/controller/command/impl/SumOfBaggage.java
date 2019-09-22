package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

/**
 * SumOfBaggage is the class that is used for calling calcSumOfBaggage method.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class SumOfBaggage implements Command {

    /**
     * Method for calling method calcSumOfBaggage() from service layer.
     *
     * @param request - request from user.
     * @return response to user.
     */
    @Override
    public String execute(final String request) {
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        double sumOfBaggage = carService.calcSumOfBaggage();

        response = "Sum of baggage " + sumOfBaggage;

        return response;
    }
}
