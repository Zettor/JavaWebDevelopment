package by.yasenko.task2.service.thread;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.filler.impl.FillerLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LockThread implements Runnable {

    /**
     * Matrix.
     */
    private Matrix matrix;

    /**
     * Number of this thread for filling matrix.
     */
    private int number;

    /**
     * Object with method of filling matrix with locker and latch.
     */
    private FillerLock fillerLock;

    /**
     * Logger for this class.
     */
    private final Logger logger = LogManager.getLogger(LockThread.class);

    /**
     * Constructor - create a new object object
     * with the parameters indicated below.
     *
     * @param fillerLock - Object with method of filling matrix only with locker
     * @param number     - number for this thread
     */
    public LockThread(final FillerLock fillerLock, final int number) {

        this.fillerLock = fillerLock;
        this.matrix = Matrix.getInstance();
        this.number = number;
    }

    @Override
    public void run() {

        logger.debug(" starting of filling with locker");
        while (matrix.getN() != fillerLock.getCount()) {
            try {
                fillerLock.fill(matrix, number);
            } catch (ServiceException e) {
                logger.debug(e.getMessage());
            } finally {
                logger.debug(" finishing of filling one element ");
            }
        }

    }
}
