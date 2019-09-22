package by.ysenko.task1.repository;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.service.specification.Specification;

import java.util.ArrayList;

/**
 * Interface for RepositoryImpl class.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public interface CarRepository {

    /**
     * Method for adding car to storage.
     *
     * @param car - some car.
     */
    void addCar(Car car);

    /**
     * Method for removing car from storage.
     *
     * @param index - index of removing car.
     */
    void deleteCar(int index);

    /**
     * Method for adding car to storage.
     *
     * @param specification - one of specification classes.
     * @return special ArrayList of cars.
     */
    ArrayList<Car> querry(Specification specification);

    /**
     * Method for getting ArratList of cars from storage.
     *
     * @return copy of ArrayList from storage.
     */
    ArrayList<Car> getAll();


}
