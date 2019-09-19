package by.ysenko.task1.dao.exception;

public class WriterException extends Exception {

    public static final long serialVersionUID = 1L;

    public WriterException(){
        super();
    }

    public WriterException(String message){
        super(message);
    }

    public WriterException(Exception e){
        super(e);
    }

    public WriterException(String message,Exception e){
        super(message,e);
    }
}
