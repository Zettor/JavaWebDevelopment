package by.yasenko.task2.controller;

import by.yasenko.task2.controller.command.Command;
import by.yasenko.task2.controller.command.CommandName;
import by.yasenko.task2.controller.command.impl.*;


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
        repository.put(CommandName.INIT_MATRIX, new InitMatrix());
        repository.put(CommandName.SHOW_MATRIX, new ShowMatrix());
        repository.put(CommandName.FILL_SEM, new FillSem());
        repository.put(CommandName.FILL_BARRIER, new FillBarrier());
        repository.put(CommandName.FILL_LATCH, new FillLatch());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.FILL_LOCK, new FillLock());
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
