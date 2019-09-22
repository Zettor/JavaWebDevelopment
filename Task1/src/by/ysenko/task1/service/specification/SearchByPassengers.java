package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.Coach;

import java.util.ArrayList;

/**
 * Class for searching by passengers.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class SearchByPassengers implements Specification {

    /**
     * First number of passengers.
     */
    private int startNumber;

    /**
     * Second number of passengers.
     */
    private int endNumber;

    /**
     * Constructor - create a new SearchByPassengers
     * object with special parameters.
     *
     * @param startNumber - first number of passengers.
     * @param endNumber   - second number of passengers.
     */
    public SearchByPassengers(final int startNumber, final int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    @Override
    public ArrayList<Car> querry(final ArrayList<Car> storage) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : storage) {
            if ((car instanceof Coach)
                    && ((Coach) car).getPassengers() >= startNumber
                    && ((Coach) car).getPassengers() <= endNumber) {
                result.add(car);
            }
        }
        return result;
    }
}
