package by.ysenko.task1.service.factory;

import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.impl.CarServiceImpl;

/**
 * It is class with Singleton pattern,
 * where CarService object is stored.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class ServiceFactory {

    /**
     * Instance of ServiceFactory class.
     */
    private static final ServiceFactory instance = new ServiceFactory();

    /**
     * Object of CarService class.
     */
    private final CarService carService = new CarServiceImpl();

    private ServiceFactory() {
    }

    /**
     * Method of getting instance.
     *
     * @return instance.
     */
    public static ServiceFactory getInstance() {
        return instance;
    }

    /**
     * Method of getting carService.
     *
     * @return carService.
     */
    public CarService getCarService() {
        return carService;
    }
}
