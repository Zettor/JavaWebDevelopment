package by.ysenko.task1.bean;

abstract public class Car {

    protected static long id;

    /**
     * Quality for standart car.
     */
    protected static final String STANDART_NAME = "MPT-300";

    /**
     * Number of workers for standart car.
     */
    protected static final int STANDART_WORKERS = 4;

    /**
     * Weight of standart car in t.
     */
    protected static final double STANDART_WEIGHT = 61;

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

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(final int workers) {

        this.workers = workers;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(final double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getId() {
        return id;
    }
}
