package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;

import java.util.ArrayList;

/**
 * Class for searching by name.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class SearchByName implements Specification {

    /**
     * Name of car.
     */
    private String name;

    /**
     * Constructor - create a new SearchByName object with special parameters.
     *
     * @param name    - name of car.
     */
    public SearchByName(final String name) {
        this.name = name;
    }

    @Override
    public ArrayList<Car> querry(final ArrayList<Car> storage) {
        ArrayList<Car> result = new ArrayList<>();

        for (Car car : storage) {
            if (car.getName().equals(name)) {
                result.add(car);
            }
        }
        return result;
    }
}
