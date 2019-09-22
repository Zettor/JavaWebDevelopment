package by.ysenko.task1.bean;

import java.util.Objects;

/**
 * Locomotive class with different properties.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class Locomotive extends Car {

    /**
     * Traction force of train in kN.
     */
    private final static double ABSTRACT_FORCE = 0.5;

    /**
     * Speed of locomotive in km/h.
     */
    private double speed;

    /**
     * Power of locomotive in kW.
     */
    private double power;

    /**
     * Volume of fuel of locomotive in l.
     */
    private double fuel;

    /**
     * Constructor - create a new Locomotive object with special parameters.
     *
     * @param workers - number of workers in car.
     * @param name    - name of car.
     * @param weight  - weight of car.
     * @param power   - power of locomotive.
     * @param fuel    - volume of fuel of locomotive.
     */
    public Locomotive(final int workers, final String name, final double weight,
                      final double power, final double fuel) {
        super(workers, name, weight);
        this.power = power;
        speed = power / ABSTRACT_FORCE;
        this.fuel = fuel;
    }

    /**
     * Method of getting speed field.
     *
     * @return speed of locomotive.
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Method of getting power field.
     *
     * @return power of locomotive.
     */
    public double getPower() {
        return power;
    }

    /**
     * Method of setting power and speed fields.
     *
     * @param power - power of locomotive.
     */
    public void setPower(final double power) {
        this.power = power;
        speed = power / ABSTRACT_FORCE;
    }

    /**
     * Method of getting fuel field.
     *
     * @return volume of fuel of locomotive.
     */
    public double getFuel() {
        return fuel;
    }

    /**
     * Method of setting fuel field.
     *
     * @param fuel - volume of fuel of train.
     */
    public void setFuel(final double fuel) {
        this.fuel = fuel;
    }

    /**
     * Method for comparison two Locomotive objects.
     *
     * @param o - one of two objects for comparison.
     * @return true if object are equal.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Locomotive)) {
            return false;
        }
        Locomotive that = (Locomotive) o;
        return this.getWorkers() == that.getWorkers()
                && this.getName().equals(that.getName())
                && this.getWeight() == that.getWeight()
                && that.speed == speed
                && that.power == power
                && that.fuel == fuel;
    }

    /**
     * Method for generating hashcode of object.
     *
     * @return hashcode of object .
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWorkers() + getWeight() + power + speed + fuel);
    }

    /**
     * Method for converting an object to a string.
     *
     * @return data of object in String.
     */
    @Override
    public String toString() {
        return "Locomotive: "
                + "id=" + getId()
                + "workers=" + getWorkers()
                + ", name=" + getName()
                + ", weight=" + getWeight() + " kg"
                + ", speed=" + speed + " km/h"
                + ", power=" + power + " kW"
                + ", fuel=" + fuel + " l";
    }
}
