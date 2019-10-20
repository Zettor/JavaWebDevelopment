package by.ysenko.task3.service.factory;

import by.ysenko.task3.service.TextService;
import by.ysenko.task3.service.impl.TextServiceImpl;

public final class ServiceFactory {

    /**
     * Instance of ServiceFactory class.
     */
    private static final ServiceFactory instance = new ServiceFactory();

    /**
     * Object of TextService class.
     */
    private final TextService textService = new TextServiceImpl();

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
    public TextService getTextService() {
        return textService;
    }
}
