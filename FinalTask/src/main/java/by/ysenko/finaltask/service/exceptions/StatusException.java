package by.ysenko.finaltask.service.exceptions;

public class StatusException extends Exception {

    public StatusException(String param) {
        super(String.format("Empty or incorrect %s", param ));
    }
}
