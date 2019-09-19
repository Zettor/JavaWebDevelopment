package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.exception.ServiceException;
import by.ysenko.task1.service.factory.ServiceFactory;

public class AddCars implements Command {
    @Override
    public String execute(String request) {

        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        try {
            carService.addCars();
            response = "Cars add to train.";
        } catch (ServiceException e) {
            response = e.getMessage();
        }

        return response;
    }
}