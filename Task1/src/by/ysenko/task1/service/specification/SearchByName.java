package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;

import java.util.ArrayList;
import java.util.List;

public class SearchByName implements Specification {

    private String name;

   public SearchByName(final String name) {
        this.name = name;
    }

    @Override
    public ArrayList<Car> querry(ArrayList<Car> storage) {
        ArrayList<Car> result = new ArrayList<>();

        for (Car car : storage) {
            if (car.getName().equals(name)) {
                result.add(car);
            }
        }
        return result;
    }
}
