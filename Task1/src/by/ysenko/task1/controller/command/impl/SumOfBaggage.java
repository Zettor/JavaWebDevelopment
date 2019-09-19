package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

public class SumOfBaggage implements Command {
    @Override
    public String execute(String request) {
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        double sumOfBaggage = carService.getSumOfBaggage();

        response = "Sum of baggage " + sumOfBaggage;

        return response;
    }
}
