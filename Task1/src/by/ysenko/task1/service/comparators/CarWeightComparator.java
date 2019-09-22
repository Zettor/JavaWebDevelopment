package by.ysenko.task1.service.comparators;

import by.ysenko.task1.bean.Car;

import java.util.Comparator;

/**
 * Class for sort cars by first letters of their weight.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class CarWeightComparator implements Comparator<Car> {

    /**
     * Method for comparison of two cars by weight.
     *
     * @param o1 - first car.
     * @param o2 - second car.
     * @return negative number, if weight o2 > o1.
     * positive number, if weight o1 > o2.
     * 0, if weight o1 = o2.
     */
    @Override
    public int compare(final Car o1, final Car o2) {
        return (int) (o1.getWeight() - o2.getWeight());
    }
}
