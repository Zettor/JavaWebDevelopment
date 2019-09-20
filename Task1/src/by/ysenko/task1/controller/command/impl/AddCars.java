package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.exception.ServiceException;
import by.ysenko.task1.service.factory.ServiceFactory;

public class AddCars implements Command {

    private final static String PATH_TO_FILE = "D:\\Курсы\\JavaWebDevelopment\\" +
            "Task1\\src\\data\\input.txt";

    @Override
    public String execute(String request) {

        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        try {
            carService.addCars(PATH_TO_FILE);
            response = "Cars add to train.";
        } catch (ServiceException e) {
            response = e.getMessage();
        }

        return response;
    }
}