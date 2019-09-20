package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;

import java.util.ArrayList;
import java.util.List;

public class SearchByWeight implements Specification {

    private double startWeight;
    private double endWeight;

    public SearchByWeight(final double startWeight, final double endWeight) {
        this.startWeight = startWeight;
        this.endWeight = endWeight;
    }

    @Override
    public ArrayList<Car> querry(ArrayList<Car> storage) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : storage) {
            if (car.getWeight() >= startWeight && car.getWeight() <= endWeight) {
                result.add(car);
            }
        }
        return result;

    }
}
