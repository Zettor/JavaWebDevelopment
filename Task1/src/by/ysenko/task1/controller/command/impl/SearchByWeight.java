package by.ysenko.task1.controller.command.impl;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.factory.ServiceFactory;

public class SearchByWeight implements Command {
    @Override
    public String execute(String request) {

        String[] tokens=request.split(" ");

        String response="";

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        double start = Double.parseDouble(tokens[1]);

        double end = Double.parseDouble(tokens[2]);

        for(Car car : carService.searchByWeight(start,end)){
            response+=car.toString()+"\n";
        }

        return response;

    }
}
