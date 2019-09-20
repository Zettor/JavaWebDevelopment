package by.ysenko.task1.repository;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.service.specification.Specification;

import java.util.ArrayList;
import java.util.List;

public interface CarRepository {

    public void addCar(Car car);

    public void deleteCar(int index);

    public ArrayList<Car> querry(Specification specification);

    public ArrayList<Car> getAll();




}
