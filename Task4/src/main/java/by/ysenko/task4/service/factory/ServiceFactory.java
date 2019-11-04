package by.ysenko.task4.service.factory;


import by.ysenko.task4.service.FlowerService;
import by.ysenko.task4.service.impl.FlowerServiceImpl;

public final class ServiceFactory {

    /**
     * Instance of ServiceFactory class.
     */
    private static final ServiceFactory instance = new ServiceFactory();

    /**
     * Object of TextService class.
     */
    private final FlowerService flowerService = new FlowerServiceImpl();

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
    public FlowerService getTextService() {
        return flowerService;
    }
}
