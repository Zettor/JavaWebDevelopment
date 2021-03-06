package by.ysenko.task3.controller;

import by.ysenko.task3.controller.command.Command;
import by.ysenko.task3.controller.command.impl.SortByToken;
import by.ysenko.task3.controller.command.impl.SortByWord;
import by.ysenko.task3.controller.command.impl.WrongRequest;
import by.ysenko.task3.controller.command.CommandName;
import by.ysenko.task3.controller.command.impl.GetText;
import by.ysenko.task3.controller.command.impl.ReadText;
import by.ysenko.task3.controller.command.impl.SortBySentence;

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
        repository.put(CommandName.GET_TEXT, new GetText());
        repository.put(CommandName.READ_TEXT, new ReadText());
        repository.put(CommandName.SORT_BY_SENTENCE, new SortBySentence());
        repository.put(CommandName.SORT_BY_WORD, new SortByWord());
        repository.put(CommandName.SORT_BY_TOKEN, new SortByToken());
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
