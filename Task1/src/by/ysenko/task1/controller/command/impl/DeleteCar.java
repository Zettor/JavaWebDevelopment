package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.exception.ServiceException;
import by.ysenko.task1.service.factory.ServiceFactory;

/**
 * DeleteCar is the class that is used for calling deleteCar method.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class DeleteCar implements Command {

    /**
     * Method for calling method deleteCar(int index) from service layer.
     *
     * @param request - request from user.
     * @return response to user.
     */
    @Override
    public String execute(final String request) {

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
