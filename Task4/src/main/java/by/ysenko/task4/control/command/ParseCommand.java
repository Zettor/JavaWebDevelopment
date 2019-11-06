package by.ysenko.task4.control.command;

import by.ysenko.task4.bean.Flower;
import by.ysenko.task4.service.FlowerService;
import by.ysenko.task4.service.factory.ServiceFactory;

import java.util.Set;

public class ParseCommand {

    public static Set<Flower> execute(final String request) {


        String[] tokens = request.split(" ");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FlowerService flowerService = serviceFactory.getTextService();

        switch (tokens[0]) {
            case "DOM":
                return flowerService.DOMExtractor(tokens[1], tokens[2]);
            case "SAX":
                return flowerService.SAXExtractor(tokens[1], tokens[2]);
            default:
                return flowerService.StAXExtractor(tokens[1].replace("file:///",""));
        }
    }
}
