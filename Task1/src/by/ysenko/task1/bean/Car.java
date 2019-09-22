package by.ysenko.task1.bean;

/**
 * Abstract Car class with different properties.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
abstract public class Car {

    /**
     * Id of car.
     */
    private static long id;

    /**
     * Number of workers for car.
     */
    private int workers;

    /**
     * Name of car.
     */
    private String name;

    /**
     * Weight of car in t.
     */
    private double weight;

    protected Car(final int workers, final String name, final double weight) {
        this.workers = workers;
        this.name = name;
        this.weight = weight;
        id++;
    }

    /**
     * Method of getting workers field.
     *
     * @return number of workers.
     */
    public int getWorkers() {
        return workers;
    }

    /**
     * Method of setting workers field.
     *
     * @param workers - number of workers.
     */
    public void setWorkers(final int workers) {

        this.workers = workers;
    }

    /**
     * Method of getting wieght field.
     *
     * @return weight if car.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Method of setting weight field.
     *
     * @param weight - weight of car.
     */
    public void setWeight(final double weight) {
        this.weight = weight;
    }

    /**
     * Method of getting name field.
     *
     * @return name of car.
     */
    public String getName() {
        return name;
    }

    /**
     * Method of setting name field.
     *
     * @param name - name off car.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Method of getting id field.
     *
     * @return id of car.
     */
    public static long getId() {
        return id;
    }
}
