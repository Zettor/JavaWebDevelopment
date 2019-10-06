package by.yasenko.task2.service.filler.impl;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.factory.ServiceFactory;
import by.yasenko.task2.service.filler.Filler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public final class FillerLatch implements Filler {

    private ReentrantLock locker;

    private CountDownLatch countDown;

    /**
     * Index of element for filling it with thread.
     */
    private static int count;

    /**
     * Logger of this class.
     */
    private final Logger logger = LogManager.getLogger(FillerLock.class);

    /**
     * Constructor - create a new object object
     * with the parameters indicated below.
     *
     * @param locker        - locker.
     * @param numberThreads - number of threads
     */
    public FillerLatch(final ReentrantLock locker, final int numberThreads) {

        countDown = new CountDownLatch(numberThreads);
        this.locker = locker;
        count = 0;
    }

    /**
     * Method for getting latch object.
     *
     * @return letch object.
     */
    public CountDownLatch getCountDown() {
        return countDown;
    }

    /**
     * Method for getting index of element for filling.
     *
     * @return index of element for filling.
     */
    public static int getCount() {
        return count;
    }

    @Override
    public void fill(final Matrix matrix,
                     final int number) throws ServiceException {

        locker.lock();

        try {
            if (count <= matrix.getN() - 1 && count <= matrix.getM() - 1) {
                logger.debug("fill() of FillerLock fill "
                        + (count + 1) + " element of diagonal with " + number);
                matrix.getMatrix()[count][count] = number;
                count++;

                logger.debug("\n" + ServiceFactory.getInstance()
                        .getMatrixService().showMatrix());

                TimeUnit.MILLISECONDS.sleep(100);
            } else {
                logger.debug("The main diagonal is already filled.");
            }
        } catch (InterruptedException e) {
            throw new ServiceException("InterruptedException in FillerLock");
        } finally {
            countDown.countDown();
            locker.unlock();
        }
    }
}
