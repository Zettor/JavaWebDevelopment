package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.Coach;

import java.util.ArrayList;
import java.util.List;

public class SearchByPassengers implements Specification {

    private int startNumber;
    private int endNumber;

    public SearchByPassengers(final int startNumber, final int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    @Override
    public List<Car> querry(ArrayList<Car> storage) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : storage) {
            if ((car instanceof Coach)
                    && ((Coach) car).getPassengers() >= startNumber
                    && ((Coach) car).getPassengers() <= endNumber) {
                result.add(car);
            }
        }
        return result;
    }
}
