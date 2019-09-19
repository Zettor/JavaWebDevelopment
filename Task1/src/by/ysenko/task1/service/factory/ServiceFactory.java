package by.ysenko.task1.service.factory;

import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.impl.CarServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final CarService carService = new CarServiceImpl();
    private ServiceFactory(){}
    public static ServiceFactory getInstance(){
        return instance;
    }
    public CarService getCarService(){
        return carService;
    }
}
