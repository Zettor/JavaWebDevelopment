package by.ysenko.task1.repository;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.TrainStorage;
import by.ysenko.task1.dao.Reader;
import by.ysenko.task1.dao.Writer;
import by.ysenko.task1.dao.factory.DAOFactory;
import by.ysenko.task1.service.specification.Specification;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    private TrainStorage train = TrainStorage.getInstance();

    private static final CarRepositoryImpl instance = new CarRepositoryImpl();

    public static CarRepositoryImpl getInstance() {
        return instance;
    }

    private CarRepositoryImpl() {
    }

    public TrainStorage getTrain() {
        return train;
    }

    @Override
    public void addCar(Car car) {
        train.add(car);
    }

    @Override
    public void deleteCar(final int index) {
        train.remove(index);
    }

    @Override
    public ArrayList<Car> querry(Specification specification) {
        return specification.querry(train.getList());
    }

    @Override
    public ArrayList<Car> getAll() {
        return train.getList();
    }


}




