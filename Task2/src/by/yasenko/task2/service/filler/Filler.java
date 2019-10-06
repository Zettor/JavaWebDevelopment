package by.yasenko.task2.service.filler;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.service.exception.ServiceException;

public interface Filler {

    /**
     * Method for filling matrix diagonal.
     *
     * @param matrix - matrix
     * @param number - special number of thread
     * @throws ServiceException - exception in Service layer
     */
    void fill(Matrix matrix, int number) throws ServiceException;

}
