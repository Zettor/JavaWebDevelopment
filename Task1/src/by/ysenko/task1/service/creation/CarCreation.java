package by.ysenko.task1.service.creation;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.service.exception.ServiceException;

public interface CarCreation {

    public  Car createCar(String[] tokens) throws ServiceException;


}
