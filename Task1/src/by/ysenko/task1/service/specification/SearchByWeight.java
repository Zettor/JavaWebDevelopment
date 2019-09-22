package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;

import java.util.ArrayList;
/**
 * Class for searching by weight.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class SearchByWeight implements Specification {

    /**
     * First weight.
     */
    private double startWeight;

    /**
     * Second weight.
     */
    private double endWeight;

    /**
     * Constructor - create a new SearchByWeight
     * object with special parameters.
     *
     * @param startWeight - first weight.
     * @param endWeight   - second weight.
     */
    public SearchByWeight(final double startWeight, final double endWeight) {
        this.startWeight = startWeight;
        this.endWeight = endWeight;
    }

    @Override
    public ArrayList<Car> querry(final ArrayList<Car> storage) {
        ArrayList<Car> result = new ArrayList<>();
        for (Car car : storage) {
            if (car.getWeight() >= startWeight
                    && car.getWeight() <= endWeight) {
                result.add(car);
            }
        }
        return result;

    }
}
