package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.service.comparators.CarWeightComparator;

import java.util.ArrayList;
import java.util.List;

public class SortByWeight implements Specification {

   public SortByWeight() {

    }

    @Override
    public ArrayList<Car> querry(ArrayList<Car> storage) {
        ArrayList<Car> result = new ArrayList<>(storage);

        result.sort(new CarWeightComparator());

        return result;
    }
}
