package by.ysenko.task4.control.command;

import by.ysenko.task4.bean.Flower;
import by.ysenko.task4.service.FlowerService;
import by.ysenko.task4.service.factory.ServiceFactory;

import java.util.Set;

public class ValidateCommand {

    public static String execute(final String request) {
        String response = "";

        String[] tokens = request.split(" ");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FlowerService flowerService = serviceFactory.getTextService();

        return flowerService.Validate(tokens[0],tokens[1]);
    }
}
