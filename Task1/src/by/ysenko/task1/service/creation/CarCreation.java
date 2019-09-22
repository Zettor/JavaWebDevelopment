package by.ysenko.task1.service.creation;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.service.exception.ServiceException;

/**
 * This interface of classes of creation cars.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public interface CarCreation {

    /**
     * Method for creation cars.
     * @param tokens - Strings with data for cars.
     * @return new car.
     */
     Car createCar(String[] tokens) throws ServiceException;


}
