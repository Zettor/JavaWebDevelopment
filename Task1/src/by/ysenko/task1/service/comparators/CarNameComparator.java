package by.ysenko.task1.service.comparators;

import by.ysenko.task1.bean.Car;

import java.util.Comparator;

public class CarNameComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {

        char name1=o1.getName().toLowerCase().charAt(0);
        char name2=o2.getName().toLowerCase().charAt(0);

        return name1-name2;
    }


}
