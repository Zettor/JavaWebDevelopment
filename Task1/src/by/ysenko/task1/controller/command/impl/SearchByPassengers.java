package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

public class SearchByPassengers implements Command {


    @Override
    public String execute(String request) {

        String[] tokens = request.split(" ");

        String response="";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        int start = Integer.parseInt(tokens[1]);
        int end = Integer.parseInt(tokens[2]);

        for(Car car : carService.searchByPassengers(start, end)){
            response+=car.toString()+"\n";
        }

        return response;
    }
}
