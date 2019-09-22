package by.ysenko.task1.service;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.service.exception.ServiceException;

import java.util.List;

public interface CarService {


    /**
     * Method for calculating sum of baggage.
     *
     * @return sum of baggage.
     */
    double calcSumOfBaggage();

    /**
     * Method for calculating sum of passengers.
     *
     * @return sum of passengers.
     */
    int calcSumOfPassengers();

    /**
     * Method for calculating sum of speed.
     *
     * @return sum of speed.
     */
    double calcSumOfSpeed();

    /**
     * Method for adding cars to storage.
     *
     * @param path - path to file.
     * @throws ServiceException - exception in Service layer.
     */
    void addCars(String path) throws ServiceException;

    /**
     * Method for removing cars from storage.
     *
     * @param index - index of car.
     * @throws ServiceException - exception in Service layer.
     */
    void deleteCar(int index) throws ServiceException;

    /**
     * Method for searching by name in storage.
     *
     * @param name - name of car.
     * @return cars with special name.
     */
    List<Car> searchByName(String name);

    /**
     * Method for searching by passengers in storage.
     *
     * @param start - first number.
     * @param end   - second number.
     * @return cars with number of passengers.
     */
    List<Car> searchByPassengers(int start, int end);

    /**
     * Method for searching by weight in storage.
     *
     * @param start - first weight.
     * @param end   - second weight.
     * @return cars with special weight.
     */
    List<Car> searchByWeight(double start, double end);

    /**
     * Method for sorting by name in storage.
     *
     * @return sorting storage by name.
     */
    List<Car> sortByName();

    /**
     * Method for sorting by weight in storage.
     *
     * @return sorting storage by weight.
     */
    List<Car> sortByWeight();

    /**
     * Method for getting copy of storage.
     *
     * @return copy of storage of cars.
     */
    List<Car> getAll();

}
