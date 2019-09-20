package by.ysenko.task1.service.impl;

import by.ysenko.task1.bean.BaggageCar;
import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.Coach;
import by.ysenko.task1.bean.Locomotive;
import by.ysenko.task1.dao.Reader;
import by.ysenko.task1.dao.Writer;
import by.ysenko.task1.dao.exception.ReaderException;
import by.ysenko.task1.dao.exception.WriterException;
import by.ysenko.task1.dao.factory.DAOFactory;
import by.ysenko.task1.repository.CarRepositoryImpl;
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
import java.util.List;

public class CarServiceImpl implements CarService {



    private static final Logger LOGGER = LogManager.getLogger(CarService.class);

    @Override
    public double calcSumOfBaggage() {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

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

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

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

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        ArrayList<Car> storage = repository.getAll();

        double result = 0.0;

        for (Car car : storage) {

            if (car instanceof Locomotive)
                result += ((Locomotive) car).getSpeed();
        }
        return result;
    }

    @Override
    public void addCars(String path) throws ServiceException {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        Reader reader = daoObjectFactory.getReader();
        ArrayList<String> lines = null;

        try {
            lines = reader.read(path);
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

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        if (index >= 0 && index < repository.getAll().size()) {
            repository.deleteCar(index);
        } else {
            throw new ServiceException("The train is empty or method got wrong index.");
        }
    }

    @Override
    public List<Car> searchByName(String name) {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        writeToFile(repository.querry(new SearchByName(name)));
        return repository.querry(new SearchByName(name));
    }

    @Override
    public List<Car> searchByPassengers(final int start, final int end) {
        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        writeToFile(repository.querry(new SearchByPassengers(start, end)));
        return repository.querry(new SearchByPassengers(start, end));
    }

    @Override
    public List<Car> searchByWeight(final double start, final double end) {
        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        writeToFile(repository.querry(new SearchByWeight(start, end)));
        return repository.querry(new SearchByWeight(start, end));
    }

    @Override
    public List<Car> sortByName() {
        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();
        writeToFile(repository.querry(new SortByName()));
        return repository.querry(new SortByName());
    }

    @Override
    public List<Car> sortByWeight() {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();
        writeToFile(repository.querry(new SortByWeight()));
        return repository.querry(new SortByWeight());
    }

    @Override
    public List<Car> getAll() {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        writeToFile(repository.getAll());
        return repository.getAll();
    }

    public void writeToFile(ArrayList<Car> train) {


        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        Writer writer = daoObjectFactory.getWriter();

        ArrayList<String> lines = new ArrayList<String>();

        for (Car car : train) {
            lines.add(car.toString());
        }

        try {
            writer.write("D:\\Курсы\\JavaWebDevelopment\\Task1\\src\\data\\output.txt", lines);
        } catch (WriterException ex) {
            LOGGER.error(ex.getMessage());
        }
    }


}
