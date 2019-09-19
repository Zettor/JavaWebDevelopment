package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

import java.util.Arrays;

public class SearchByName implements Command {


    @Override
    public String execute(String request) {

        String[] tokens=request.split(" ");

        String response="";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        for(Car car : carService.searchByName(tokens[1])){
            response+=car.toString()+"\n";
        }

        return response;
    }
}
