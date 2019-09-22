package by.ysenko.task1.service.creation;

import by.ysenko.task1.bean.BaggageCar;
import by.ysenko.task1.bean.Car;
import by.ysenko.task1.service.exception.ServiceException;

/**
 * This class creat BaggageCar objects.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class BaggageCarCreation implements CarCreation {


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
     * String with baggage data.
     */
    private static final int BAGGAGE_TOKEN = 3;

    @Override
    public Car createCar(final String[] tokens) throws ServiceException {

        int workers;
        String name;
        double weight;
        double baggage;

        try {
            workers = Integer.parseInt(tokens[WORKERS_TOKEN]);
            name = tokens[NAME_TOKEN];
            weight = Double.parseDouble(tokens[WEIGHT_TOKEN]);
            baggage = Double.parseDouble(tokens[BAGGAGE_TOKEN]);

        } catch (NumberFormatException ex) {
            throw new ServiceException("BaggageCreation's method"
                    + " got date of wrong format");
        }
        return new BaggageCar(workers, name, weight, baggage);
    }
}
