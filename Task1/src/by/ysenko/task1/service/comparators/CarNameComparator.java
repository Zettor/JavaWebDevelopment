package by.ysenko.task1.service.comparators;

import by.ysenko.task1.bean.Car;

import java.util.Comparator;

/**
 * Class for sort cars by first letters of their names
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class CarNameComparator implements Comparator<Car> {

    /**
     * Method for comparison of two cars by first letters of their names.
     *
     * @param o1 - first car.
     * @param o2 - second car.
     * @return negative number, if first letter of name o2 > o1.
     * positive number, if first letter of name o1 > o2.
     * mean from other comparator,because first letter of name o1 = o2.
     */
    @Override
    public int compare(final Car o1, final Car o2) {

        char name1 = o1.getName().toLowerCase().charAt(0);
        char name2 = o2.getName().toLowerCase().charAt(0);
        if (name1 == name2) {
            return new CarWeightComparator().compare(o1, o2);
        }
        return name1 - name2;
    }


}
