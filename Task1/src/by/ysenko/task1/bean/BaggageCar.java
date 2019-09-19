package by.ysenko.task1.bean;

import java.util.Objects;

public class BaggageCar extends Car {

    /**
     * Weight of baggage in kg.
     */
    private double baggage;

    public BaggageCar(final int workers,
                      final String name, final double weight,
                      final double baggage) {
        super(workers, name, weight);
        this.baggage = baggage;
    }

    public double getBaggage() {
        return baggage;
    }

    public void setBaggage(final double baggage) {
        if (baggage >= 0) {
            this.baggage = baggage;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaggageCar that = (BaggageCar) o;
        return this.getWorkers() == ((Coach) o).getWorkers() &&
                this.getName().equals(this.getName()) &&
                this.getWeight() == this.getWeight() &&
                Double.compare(that.baggage, baggage) == 0;
    }

    @Override
    public String toString() {
        return "BaggageCar: " +
                "workers=" + getWorkers() +
                ", name=" + getName() +
                ", weight=" + getWeight() + " kg" +
                ", baggage=" + baggage + " kg";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorkers()+getWeight()+baggage);
    }
}
