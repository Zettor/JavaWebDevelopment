package by.ysenko.task1.service.creation;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.Coach;
import by.ysenko.task1.bean.TypeOfCoach;
import by.ysenko.task1.service.exception.ServiceException;

/**
 * This class creat Coach objects.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class CoachCreation implements CarCreation {

    /**
     * String with workers data.
     */
    private static final int WORKERS_TOKEN = 0;

    /**
     * String with name data.
     */
    private static final int NAME_TOKEN = 1;

    /**
     * String with weight data.
     */
    private static final int WEIGHT_TOKEN = 2;

    /**
     * String with passengers data.
     */
    private static final int PASSENGERS_TOKEN = 3;

    /**
     * String with Type of coach data.
     */
    private static final int TYPE_OF_COACH_TOKEN = 4;

    @Override
    public Car createCar(final String[] tokens) throws ServiceException {

        int workers;
        String name;
        double weight;
        int passengers;

        try {
            workers = Integer.parseInt(tokens[WORKERS_TOKEN]);
            name = tokens[NAME_TOKEN];
            weight = Double.parseDouble(tokens[WEIGHT_TOKEN]);
            passengers = Integer.parseInt(tokens[PASSENGERS_TOKEN]);

        } catch (NumberFormatException ex) {
            throw new ServiceException("CoachCreation's method"
                    + " got date of wrong format");
        }
        TypeOfCoach type;

        switch (tokens[TYPE_OF_COACH_TOKEN]) {

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
