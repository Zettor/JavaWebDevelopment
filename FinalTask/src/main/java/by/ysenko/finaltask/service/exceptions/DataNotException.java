package by.ysenko.finaltask.service.exceptions;

public class DataNotException extends Exception {

    public DataNotException(String param) {
        super(String.format("This %s don't exists yet!", param));
    }
}
