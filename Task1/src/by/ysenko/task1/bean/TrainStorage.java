package by.ysenko.task1.bean;

import java.util.ArrayList;

/**
 * TrainStorage is class with pattern Singleton where different cars are stored.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class TrainStorage {

    /**
     * Collection storage, where different cars are stored.
     */
    private ArrayList<Car> storage;

    /**
     * Instance of this class.
     */
    private static final TrainStorage instance = new TrainStorage();

    /**
     * Method of getting instance field.
     *
     * @return instance of this class.
     */
    public static TrainStorage getInstance() {
        return instance;
    }

    /**
     * Constructor - create a TrainStorage object.
     */
    public TrainStorage() {
        storage = new ArrayList<>();
    }

    /**
     * Method for adding car to storage.
     *
     * @param car - car object.
     */
    public void add(final Car car) {
        storage.add(car);
    }

    /**
     * Method for removing car from storage.
     *
     * @param index - index of car in storage.
     */
    public void remove(final int index) {
        if (!storage.isEmpty()) {
            storage.remove(index);
        }
    }

    /**
     * Method of getting copy of storage.
     *
     * @return copy of storage.
     */
    public ArrayList<Car> getList() {
        return new ArrayList(storage);
    }
}
