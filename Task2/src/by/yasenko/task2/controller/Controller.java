package by.yasenko.task2.controller;

import by.yasenko.task2.controller.command.Command;

/**
 * Class where programm refers to a specific command class.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public class Controller {

    /**
     * Object of class CommandProvider.
     */
    private final CommandProvider provider = new CommandProvider();

    /**
     * Delimiter for user request splitting.
     */
    private final static char PARAM_DELIMETER = ' ';

    /**
     * Method of calling different commands.
     *
     * @param request - request from user.
     * @return response to user.
     */
    public String executeTask(final String request) {

        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(PARAM_DELIMETER));
        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request);

        return response;
    }
}
