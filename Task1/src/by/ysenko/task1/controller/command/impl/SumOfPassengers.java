package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

public class SumOfPassengers implements Command {
    @Override
    public String execute(String request) {
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        double sumOfPassengers = carService.getSumOfPassengers();

        response = "Sum of baggage " + sumOfPassengers;

        return response;
    }
}
