package by.ysenko.task1.controller;

import by.ysenko.task1.controller.command.Command;
import by.ysenko.task1.controller.command.CommandName;
import by.ysenko.task1.controller.command.impl.GetAll;
import by.ysenko.task1.controller.command.impl.SumOfPassengers;
import by.ysenko.task1.controller.command.impl.SumOfSpeed;
import by.ysenko.task1.controller.command.impl.WrongRequest;
import by.ysenko.task1.controller.command.impl.AddCars;
import by.ysenko.task1.controller.command.impl.DeleteCar;
import by.ysenko.task1.controller.command.impl.SearchByName;
import by.ysenko.task1.controller.command.impl.SearchByPassengers;
import by.ysenko.task1.controller.command.impl.SearchByWeight;
import by.ysenko.task1.controller.command.impl.SortByName;
import by.ysenko.task1.controller.command.impl.SortByWeight;
import by.ysenko.task1.controller.command.impl.SumOfBaggage;

import java.util.HashMap;
import java.util.Map;

/**
 * Class with repository of commands and methods to work with them.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
final class CommandProvider {

    /**
     *Map where commands are stored.
     */
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.ADD_CARS, new AddCars());
        repository.put(CommandName.DELETE_CAR, new DeleteCar());
        repository.put(CommandName.SEARCH_BY_NAME, new SearchByName());
        repository.put(CommandName.SEARCH_BY_PASSENGERS,
                new SearchByPassengers());
        repository.put(CommandName.SEARCH_BY_WEIGHT, new SearchByWeight());
        repository.put(CommandName.SORT_BY_NAME, new SortByName());
        repository.put(CommandName.SORT_BY_WEIGHT, new SortByWeight());
        repository.put(CommandName.SUM_BAGGAGE, new SumOfBaggage());
        repository.put(CommandName.SUM_PASSENGERS, new SumOfPassengers());
        repository.put(CommandName.SUM_SPEED, new SumOfSpeed());
        repository.put(CommandName.GET_ALL, new GetAll());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    Command getCommand(final String name) {
        CommandName commandName = null;

        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }

}
