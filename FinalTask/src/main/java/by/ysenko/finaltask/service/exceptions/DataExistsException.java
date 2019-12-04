package by.ysenko.finaltask.service.exceptions;

public class DataExistsException extends Exception {

    public DataExistsException(String param) {
        super(String.format("This %s already exists!", param));
    }
}
