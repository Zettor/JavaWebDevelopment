package by.ysenko.task1.bean;

import java.util.Objects;

public class Locomotive extends Car {

    private final static double ABSTRACT_FORCE = 100;

    private final static double STANDART_FUEL = 6000;

    private double speed;

    private double power;

    private double fuel;

    public Locomotive(final int workers, final String name, final double weight,
                      final double power, final double fuel) {
        super(workers, name, weight);
        this.power = power;
        speed = power / ABSTRACT_FORCE;
        this.fuel = fuel;
    }

    public double getSpeed() {
        return speed;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
        speed = power / ABSTRACT_FORCE;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locomotive that = (Locomotive) o;
        return this.getWorkers() == ((Coach) o).getWorkers() &&
                this.getName().equals(this.getName()) &&
                this.getWeight() == this.getWeight() &&
                Double.compare(that.speed, speed) == 0 &&
                Double.compare(that.power, power) == 0 &&
                Double.compare(that.fuel, fuel) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorkers() + getWeight() + power + speed + fuel);
    }

    @Override
    public String toString()  {
        return "Locomotive: " +
                "workers=" + getWorkers() +
                ", name=" + getName() +
                ", weight=" + getWeight() + " kg" +
                ", speed=" + speed + " km/s" +
                ", power=" + power + " kW" +
                ", fuel=" + fuel + " l";
    }
}
