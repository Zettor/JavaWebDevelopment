package by.ysenko.task1.service.comparators;

import by.ysenko.task1.bean.Car;

import java.util.Comparator;

public class CarWeightComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return (int) (o1.getWeight() - o2.getWeight());
    }
}
