package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;

import java.util.ArrayList;


/**
 * Interface for different operation with storage of cars.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public interface Specification {
    /**
     * Method for different operation with storage of cars.
     * @param storage - copy of storage of cars.
     * @return edit copy of storage of cars
     */
    ArrayList<Car> querry(ArrayList<Car> storage);
}
