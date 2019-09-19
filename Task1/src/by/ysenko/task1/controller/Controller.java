package by.ysenko.task1.controller;

import by.ysenko.task1.controller.command.Command;

public class Controller {

    private final CommandProvider provider = new CommandProvider();

    private final static char paramDelimeter = ' ';

    public String executeTask(String request) {

        String commandName;
        Command executionCommand;

        commandName = request.substring(0, request.indexOf(paramDelimeter));
        executionCommand = provider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request);

        return response;
    }
}
