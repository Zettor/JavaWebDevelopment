package by.ysenko.task1.repository;

import by.ysenko.task1.bean.*;
import by.ysenko.task1.dao.Reader;
import by.ysenko.task1.dao.exception.ReaderException;
import by.ysenko.task1.dao.factory.DAOFactory;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.creation.BaggageCarCreation;
import by.ysenko.task1.service.creation.CoachCreation;
import by.ysenko.task1.service.creation.LocomotiveCreation;
import by.ysenko.task1.service.exception.ServiceException;
import by.ysenko.task1.service.specification.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

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




