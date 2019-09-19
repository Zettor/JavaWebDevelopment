package by.ysenko.task1.service.creation;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.Coach;
import by.ysenko.task1.bean.TypeOfCoach;
import by.ysenko.task1.service.exception.ServiceException;

public class CoachCreation implements CarCreation {
    @Override
    public Car createCar(String[] tokens) throws ServiceException {

        int workers;
        String name;
        double weight;
        int passengers;

        try {
            workers = Integer.parseInt(tokens[0]);
            name = tokens[1];
            weight = Double.parseDouble(tokens[2]);
            passengers = Integer.parseInt(tokens[3]);

        } catch (NumberFormatException ex) {
            throw new ServiceException("CoachCreation's method" +
                    " got date of wrong format");
        }
        TypeOfCoach type;

        switch (tokens[4]) {

            case "soft":
                type = TypeOfCoach.SOFT;
                break;
            case "compartment":
                type = TypeOfCoach.COMPARTMENT;
                break;
            default:
                type = TypeOfCoach.BUFFET;
                break;
        }

        return new Coach(workers, name, weight, passengers, type);
    }
}
