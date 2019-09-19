package by.ysenko.task1.service.creation;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.Locomotive;
import by.ysenko.task1.service.exception.ServiceException;

public class LocomotiveCreation implements CarCreation {

    @Override
    public Car createCar(String[] tokens) throws ServiceException {

        int workers;
        String name;
        double weight;
        double power;
        double fuel;

        try {
            workers = Integer.parseInt(tokens[0]);
            name = tokens[1];
            weight = Double.parseDouble(tokens[2]);
            power = Double.parseDouble(tokens[3]);
            fuel = Double.parseDouble(tokens[4]);

        } catch (NumberFormatException ex) {
            throw new ServiceException("LocomotiveCreation's method" +
                    " got date of wrong format");
        }

        return new Locomotive(workers, name, weight, power, fuel);
    }
}
