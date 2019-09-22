package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.service.comparators.CarWeightComparator;

import java.util.ArrayList;

/**
 * Class for sorting by weight.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class SortByWeight implements Specification {

    /**
     * Constructor - create a new SortByWeight object.
     */
    public SortByWeight() {

    }

    @Override
    public ArrayList<Car> querry(final ArrayList<Car> storage) {
        ArrayList<Car> result = new ArrayList<>(storage);

        result.sort(new CarWeightComparator());

        return result;
    }
}
