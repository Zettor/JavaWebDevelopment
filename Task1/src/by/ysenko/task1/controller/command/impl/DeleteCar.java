package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.exception.ServiceException;
import by.ysenko.task1.service.factory.ServiceFactory;

public class DeleteCar implements Command {
    @Override
    public String execute(String request) {

        String response;

        String[] tokens = request.split(" ");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        int index = Integer.parseInt(tokens[1]);
        response = "Car removed from train";
        try {
            carService.deleteCar(index);
        } catch (ServiceException e) {
            response = e.getMessage();
        }
        return response;
    }
}
