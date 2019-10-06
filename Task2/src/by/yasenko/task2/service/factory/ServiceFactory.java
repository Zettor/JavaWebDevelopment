package by.yasenko.task2.service.factory;

import by.yasenko.task2.service.MatrixService;
import by.yasenko.task2.service.impl.MatrixServiceImpl;

public final class ServiceFactory {

    /**
     * Instance of ServiceFactory class.
     */
    private static final ServiceFactory instance = new ServiceFactory();

    /**
     * Object of MatrixService class.
     */
    private final MatrixService carService = new MatrixServiceImpl();

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
    public MatrixService getMatrixService() {
        return carService;
    }
}
