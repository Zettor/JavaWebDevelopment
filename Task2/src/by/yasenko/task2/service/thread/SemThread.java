package by.yasenko.task2.service.thread;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.filler.impl.FillerLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;

public final class SemThread implements Runnable {

    /**
     * Number of this thread for filling matrix.
     */
    private int number;

    /**
     * Object with method of filling matrix only with locker.
     */
    private FillerLock fillerLock;

    /**
     * Semaphore for this thread.
     */
    private Semaphore sem;

    /**
     * Logger for this class.
     */
    private final Logger logger = LogManager.getLogger(SemThread.class);

    /**
     * Matrix.
     */
    private Matrix matrix;

    /**
     * Constructor - create a new object object
     * with the parameters indicated below.
     *
     * @param fillerLock - Object with method of filling matrix only with locker
     * @param sem        - semaphore for this thread.
     * @param number     - number for this thread
     */
    public SemThread(final FillerLock fillerLock,
                     final Semaphore sem, final int number) {
        this.sem = sem;
        this.fillerLock = fillerLock;
        this.number = number;
        matrix = Matrix.getInstance();
    }

    @Override
    public void run() {
        while (matrix.getN() != fillerLock.getCount()) {
            try {
                sem.acquire();
                logger.debug(" starting of filling with semaphore");
                fillerLock.fill(matrix, number);
            } catch (ServiceException e) {
                logger.debug(e.getMessage());
            } catch (InterruptedException e) {
                logger.error("InterruptedException in SemThread");
            } finally {
                logger.debug(" finishing of filling one element ");
                sem.release();
            }
        }
    }
}
