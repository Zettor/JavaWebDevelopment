package by.ysenko.task1.bean;

import java.util.Objects;

/**
 * Coach class with different properties.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class Coach extends Car {

    /**
     * Number of passengers for coach.
     */
    private int passengers;

    /**
     * Type of coach.
     */
    private TypeOfCoach typeOfCoach;

    /**
     * Constructor - create a new Coach object with special parameters.
     *
     * @param workers     - number of workers in car.
     * @param name        - name of car.
     * @param weight      - weight of car.
     * @param passengers  - number of passengers int car.
     * @param typeOfCoach - type of coach.
     */
    public Coach(final int workers, final String name,
                 final double weight, final int passengers,
                 final TypeOfCoach typeOfCoach) {
        super(workers, name, weight);
        this.passengers = passengers;
        this.typeOfCoach = typeOfCoach;
    }

    /**
     * Method of getting passengers field.
     *
     * @return number of passengers.
     */
    public int getPassengers() {
        return passengers;
    }

    /**
     * Method of setting passengers field.
     *
     * @param passengers - number of passengers.
     */
    public void setPassengers(final int passengers) {

        this.passengers = passengers;
    }

    /**
     * Method of getting typeOfCoach field.
     *
     * @return type of coach.
     */
    public TypeOfCoach getTypeOfCoach() {
        return typeOfCoach;
    }

    /**
     * Method of setting TypeOfCoach field.
     *
     * @param typeOfCoach - type of coach.
     */
    public void setTypeOfCoach(final TypeOfCoach typeOfCoach) {
        this.typeOfCoach = typeOfCoach;
    }

    /**
     * Method for comparison two Coach objects.
     *
     * @param o - one of two objects for comparison.
     * @return true if object are equal.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Coach)) {
            return false;
        }
        Coach coach = (Coach) o;

        return this.getWorkers() == coach.getWorkers()
                && this.getName().equals(coach.getName())
                && this.getWeight() == coach.getWeight()
                && passengers == coach.passengers
                && typeOfCoach == coach.typeOfCoach;
    }

    /**
     * Method for generating hashcode of object.
     *
     * @return hashcode of object .
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWorkers() + getWeight() + passengers);
    }

    /**
     * Method for converting an object to a string.
     *
     * @return data of object in String.
     */
    @Override
    public String toString() {
        return "Coach: "
                + "id=" + getId()
                + "workers=" + getWorkers()
                + ", name=" + getName()
                + ", weight=" + getWeight() + " kg"
                + ", passengers=" + passengers
                + ", typeOfCoach=" + typeOfCoach;
    }
}
