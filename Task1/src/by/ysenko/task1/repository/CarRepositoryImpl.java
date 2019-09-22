package by.ysenko.task1.repository;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.TrainStorage;
import by.ysenko.task1.service.specification.Specification;

import java.util.ArrayList;


/**
 * This class with Singleton pattern,
 * store storage of cars and can work with this storage.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class CarRepositoryImpl implements CarRepository {

    /**
     * Storage of cars.
     */
    private TrainStorage train = TrainStorage.getInstance();

    /**
     * Instance of RepositoryImpl class.
     */
    private static final CarRepositoryImpl instance = new CarRepositoryImpl();

    /**
     * Method for getting instance of RepositoryImpl class.
     *
     * @return instance field.
     */
    public static CarRepositoryImpl getInstance() {
        return instance;
    }

    private CarRepositoryImpl() {
    }

    @Override
    public void addCar(final Car car) {
        train.add(car);
    }

    @Override
    public void deleteCar(final int index) {
        train.remove(index);
    }

    @Override
    public ArrayList<Car> querry(final Specification specification) {
        return specification.querry(train.getList());
    }

    @Override
    public ArrayList<Car> getAll() {
        return train.getList();
    }


}




