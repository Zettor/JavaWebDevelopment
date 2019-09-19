package by.ysenko.task1.bean;

import java.util.ArrayList;

public class TrainStorage {

    private ArrayList<Car> storage;

    private static final TrainStorage instance = new TrainStorage();

    public static TrainStorage getInstance() {
        return instance;
    }

    public TrainStorage() {
        storage = new ArrayList<>();
    }

    public void add(Car car) {
        storage.add(car);
    }

    public void remove(int index) {
        if (!storage.isEmpty())
            storage.remove(index);
    }

    public ArrayList<Car> getList() {
        return new ArrayList<Car>(storage);
    }

}
