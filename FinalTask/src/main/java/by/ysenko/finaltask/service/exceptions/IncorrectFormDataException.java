package by.ysenko.finaltask.service.exceptions;

public class IncorrectFormDataException extends Exception {

    public IncorrectFormDataException(String param) {
        super(String.format("Empty or incorrect %s", param ));
    }

}
