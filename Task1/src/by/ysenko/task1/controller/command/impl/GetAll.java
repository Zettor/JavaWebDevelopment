package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

public class GetAll implements Command {


    @Override
    public String execute(String request) {
        String response="";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        for(Car car : carService.getAll()){
            response+=car.toString()+"\n";
        }

        return response;
    }
}
