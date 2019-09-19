package by.ysenko.task1.service;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public interface CarService {

    public double calcSumOfBaggage();

    public int calcSumOfPassengers();

    public double calcSumOfSpeed();

    public void addCars() throws ServiceException;

    public void deleteCar(int index)throws ServiceException;

    public ArrayList<Car> searchByName(String name);

    public ArrayList<Car> searchByPassengers(final int start, final int end);

    public ArrayList<Car> searchByWeight(final double start, final double end);

    public ArrayList<Car> sortByName();

    public ArrayList<Car> sortByWeight();

    public List<Car> getAll();

}
