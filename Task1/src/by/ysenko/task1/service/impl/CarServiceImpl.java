package by.ysenko.task1.service.impl;

import by.ysenko.task1.bean.BaggageCar;
import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.Coach;
import by.ysenko.task1.bean.Locomotive;
import by.ysenko.task1.dao.Reader;
import by.ysenko.task1.dao.exception.ReaderException;
import by.ysenko.task1.dao.factory.DAOFactory;
import by.ysenko.task1.repository.CarRepositoryImp;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.creation.BaggageCarCreation;
import by.ysenko.task1.service.creation.CoachCreation;
import by.ysenko.task1.service.creation.LocomotiveCreation;
import by.ysenko.task1.service.exception.ServiceException;
import by.ysenko.task1.service.specification.*;
import by.ysenko.task1.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class CarServiceImpl implements CarService {

    private final static String PATH_TO_FILE = "D:\\Курсы\\JavaWebDevelopment\\" +
            "Task1\\src\\data\\input.txt";

    private static final Logger LOGGER = LogManager.getLogger(CarService.class);

    @Override
    public double calcSumOfBaggage() {

        CarRepositoryImp repository = new CarRepositoryImp();

        ArrayList<Car> storage = repository.getAll();

        double result = 0.0;

        for (Car car : storage) {

            if (car instanceof BaggageCar)
                result += ((BaggageCar) car).getBaggage();
        }
        return result;
    }

    @Override
    public int calcSumOfPassengers() {

        CarRepositoryImp repository = new CarRepositoryImp();

        ArrayList<Car> storage = repository.getAll();

        int result = 0;

        for (Car car : storage) {

            if (car instanceof Coach)
                result += ((Coach) car).getPassengers();
        }
        return result;
    }

    @Override
    public double calcSumOfSpeed() {

        CarRepositoryImp repository = new CarRepositoryImp();

        ArrayList<Car> storage = repository.getAll();

        double result = 0.0;

        for (Car car : storage) {

            if (car instanceof Locomotive)
                result += ((Locomotive) car).getSpeed();
        }
        return result;
    }

    @Override
    public void addCars() throws ServiceException {

        CarRepositoryImp repository = new CarRepositoryImp();

        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        Reader reader = daoObjectFactory.getReader();
        ArrayList<String> lines = null;

        try {
            lines = reader.read(PATH_TO_FILE);
        } catch (ReaderException e) {
            LOGGER.error(e.getMessage());
        }


        for (String date : lines) {
            if (Validator.validate(date)) {
                Car result;

                String[] tokens = date.split(",");

                if (tokens.length == 4) {

                    result = new BaggageCarCreation().createCar(tokens);
                } else {
                    if (tokens[4].matches("[a-zA-Z]+")) {

                        result = new CoachCreation().createCar(tokens);
                    } else {

                        result = new LocomotiveCreation().createCar(tokens);
                    }
                }

                repository.addCar(result);
            }
        }
    }


    @Override
    public void deleteCar(int index) throws ServiceException {

        CarRepositoryImp repository = new CarRepositoryImp();

        if (index >= 0 && index < repository.getAll().size()) {
            repository.deleteCar(index);
        } else {
            throw new ServiceException("The train is empty or method got wrong index.");
        }
    }

    @Override
    public ArrayList<Car> searchByName(String name) {

        CarRepositoryImp repository = new CarRepositoryImp();
        return repository.querry(new SearchByName(name));
    }

    @Override
    public ArrayList<Car> searchByPassengers(final int start, final int end) {
        CarRepositoryImp repository = new CarRepositoryImp();
        return repository.querry(new SearchByPassengers(start, end));
    }

    @Override
    public ArrayList<Car> searchByWeight(final double start, final double end) {
        CarRepositoryImp repository = new CarRepositoryImp();
        return repository.querry(new SearchByWeight(start, end));
    }

    @Override
    public ArrayList<Car> sortByName() {
        CarRepositoryImp repository = new CarRepositoryImp();

        return repository.querry(new SortByName());
    }

    @Override
    public ArrayList<Car> sortByWeight() {

        CarRepositoryImp repository = new CarRepositoryImp();

        return repository.querry(new SortByWeight());
    }

    @Override
    public ArrayList<Car> getAll() {

        CarRepositoryImp repository = new CarRepositoryImp();
        return repository.getAll();
    }
}
