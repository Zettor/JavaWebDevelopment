package by.yasenko.task2.service;

import by.yasenko.task2.service.exception.ServiceException;


public interface MatrixService {

    /**
     * Method for matrix initialization.
     *
     * @param path - path to file with data.
     * @throws ServiceException - exception in Service layer.
     */
    void createMatrix(String path) throws ServiceException;

    /**
     * Method for getting matrix in String.
     *
     * @return String with matrix
     */
    String showMatrix();

    /**
     * Method for filling matrix diagonal only with locker.
     *
     * @throws ServiceException - exception in Service layer.
     */
    void fillLock() throws ServiceException;

    /**
     * Method for filling matrix diagonal only with locker and semaphore.
     *
     * @param permits - number of permits for semaphore
     * @throws ServiceException - exception in Service layer.
     */
    void fillSem(int permits) throws ServiceException;

    /**
     * Method for filling matrix diagonal only with locker and barrier.
     *
     * @throws ServiceException - exception in Service layer.
     */
    void fillBarrier() throws ServiceException;

    /**
     * Method for filling matrix diagonal only with locker and latch.
     *
     * @throws ServiceException - exception in Service layer.
     */
    void fillLatch() throws ServiceException;

}
