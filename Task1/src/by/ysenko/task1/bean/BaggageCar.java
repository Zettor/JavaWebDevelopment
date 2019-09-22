package by.ysenko.task1.bean;

import java.util.Objects;

/**
 * BaggageCar class with different properties.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class BaggageCar extends Car {

    /**
     * Weight of baggage in kg.
     */
    private double baggage;

    /**
     * Constructor - create a new BaggageCar object with special parameters.
     *
     * @param workers - number of workers in car.
     * @param name    - name of car.
     * @param weight  - weight of car.
     * @param baggage - weight of baggage in car.
     */
    public BaggageCar(final int workers, final String name,
                      final double weight, final double baggage) {
        super(workers, name, weight);
        this.baggage = baggage;
    }

    /**
     * Method of getting baggage field.
     *
     * @return weight of baggage.
     */
    public double getBaggage() {
        return baggage;
    }

    /**
     * Method of setting baggage field.
     *
     * @param baggage - weight of baggage in car.
     */
    public void setBaggage(final double baggage) {
        if (baggage >= 0) {
            this.baggage = baggage;
        }
    }

    /**
     * Method for comparison two BaggageCar objects.
     *
     * @param o - one of two objects for comparison.
     * @return true if object are equal.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BaggageCar)) {
            return false;
        }
        BaggageCar that = (BaggageCar) o;
        return this.getWorkers() == that.getWorkers()
                && this.getName().equals(that.getName())
                && this.getWeight() == that.getWeight()
                && that.baggage == baggage;
    }

    /**
     * Method for converting an object to a string.
     *
     * @return data of object in String.
     */
    @Override
    public String toString() {
        return "BaggageCar: "
                + "id=" + getId()
                + "workers=" + getWorkers()
                + ", name=" + getName()
                + ", weight=" + getWeight() + " kg"
                + ", baggage=" + baggage + " kg";
    }

    /**
     * Method for generating hashcode of object.
     *
     * @return hashcode of object .
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWorkers() + getWeight() + baggage);
    }
}
