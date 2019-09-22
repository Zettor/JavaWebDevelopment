package by.ysenko.task1.controller.command;
/**
 * Enum of different requests.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public enum CommandName {

    /**
     * AddCars request.
     */
    ADD_CARS,

    /**
     * DeleteCar request.
     */
    DELETE_CAR,

    /**
     * Wrong request.
     */
    WRONG_REQUEST,

    /**
     * SearchByName request.
     */
    SEARCH_BY_NAME,

    /**
     * SearchByPassengers request.
     */
    SEARCH_BY_PASSENGERS,

    /**
     * SearchByWeight request.
     */
    SEARCH_BY_WEIGHT,

    /**
     * SortByName.
     */
    SORT_BY_NAME,

    /**
     * SortByWeight.
     */
    SORT_BY_WEIGHT,

    /**
     * SumOfPassengers request.
     */
    SUM_PASSENGERS,

    /**
     * SumOfBaggage request.
     */
    SUM_BAGGAGE,

    /**
     * SumOfSpeed request.
     */
    SUM_SPEED,

    /**
     * GetAll request.
     */
    GET_ALL

}
