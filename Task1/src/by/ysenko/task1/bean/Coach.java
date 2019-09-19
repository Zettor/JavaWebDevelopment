package by.ysenko.task1.bean;

import java.util.Objects;

public class Coach extends Car {

    /**
     * Number of passengers for coach.
     */
    private int passengers;

    private TypeOfCoach typeOfCoach;


    public Coach(final int workers, final String name,
                 final double weight, final int passengers, final TypeOfCoach typeOfCoach) {
        super(workers, name, weight);
        this.passengers = passengers;
        this.typeOfCoach = typeOfCoach;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(final int passengers) {

        this.passengers = passengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;

        return this.getWorkers() == ((Coach) o).getWorkers() &&
                this.getName().equals(this.getName()) &&
                this.getWeight() == this.getWeight() &&
                passengers == coach.passengers &&
                typeOfCoach == coach.typeOfCoach;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWorkers()+getWeight()+passengers);
    }

    @Override
    public String toString() {
        return "Coach: " +
                "workers=" + getWorkers() +
                ", name=" + getName() +
                ", weight=" + getWeight() + " kg" +
                ", passengers=" + passengers +
                ", typeOfCoach=" + typeOfCoach;
    }
}
