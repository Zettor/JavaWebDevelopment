package by.ysenko.task1.service.creation;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.Locomotive;
import by.ysenko.task1.service.exception.ServiceException;

/**
 * This class creat Locomotive objects.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class LocomotiveCreation implements CarCreation {

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
     * String with power data.
     */
    private static final int POWER_TOKEN = 3;

    /**
     * String with fuel data.
     */
    private static final int FUEL_TOKEN = 4;

    @Override
    public Car createCar(final String[] tokens) throws ServiceException {

        int workers;
        String name;
        double weight;
        double power;
        double fuel;

        try {
            workers = Integer.parseInt(tokens[WORKERS_TOKEN]);
            name = tokens[NAME_TOKEN];
            weight = Double.parseDouble(tokens[WEIGHT_TOKEN]);
            power = Double.parseDouble(tokens[POWER_TOKEN]);
            fuel = Double.parseDouble(tokens[FUEL_TOKEN]);

        } catch (NumberFormatException ex) {
            throw new ServiceException("LocomotiveCreation's method"
                    + " got date of wrong format");
        }

        return new Locomotive(workers, name, weight, power, fuel);
    }
}
