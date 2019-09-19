package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;

import java.util.ArrayList;

public interface Specification {

    public ArrayList<Car> querry(ArrayList<Car> storage);
}
