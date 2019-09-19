package by.ysenko.task1.service.creation;

import by.ysenko.task1.bean.*;
import by.ysenko.task1.service.exception.ServiceException;

public class BaggageCarCreation implements CarCreation {

    @Override
    public Car createCar(String[] tokens) throws ServiceException {

        int workers;
        String name;
        double weight;
        double baggage;

        try {
            workers = Integer.parseInt(tokens[0]);
            name = tokens[1];
            weight = Double.parseDouble(tokens[2]);
            baggage = Double.parseDouble(tokens[3]);

        } catch (NumberFormatException ex) {
            throw new ServiceException("BaggageCreation's method" +
                    " got date of wrong format");
        }
        return new BaggageCar(workers, name, weight, baggage);
    }
}