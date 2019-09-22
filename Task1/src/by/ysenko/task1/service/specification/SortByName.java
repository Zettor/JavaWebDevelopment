package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.service.comparators.CarNameComparator;

import java.util.ArrayList;


/**
 * Class for sorting by name.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class SortByName implements Specification {

    /**
     * Constructor - create a new SortByName object.
     */
    public SortByName() {

    }

    @Override
    public ArrayList<Car> querry(final ArrayList<Car> storage) {

        ArrayList<Car> result = new ArrayList<>(storage);

        result.sort(new CarNameComparator());
        return result;
    }
}
