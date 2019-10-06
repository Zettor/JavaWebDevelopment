package by.yasenko.task2.service.thread;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.filler.impl.FillerLatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class LatchThread implements Runnable {

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
    private FillerLatch fillerLatch;

    /**
     * Logger for this class.
     */
    private final Logger logger = LogManager.getLogger(LockThread.class);

    /**
     * Constructor - create a new object object
     * with the parameters indicated below.
     *
     * @param fillerLatch - Object with method of filling matrix only
     *                    with locker and latch.
     * @param number      - number for this thread
     */
    public LatchThread(final FillerLatch fillerLatch, final int number) {

        this.fillerLatch = fillerLatch;
        this.matrix = Matrix.getInstance();
        this.number = number;
    }

    @Override
    public void run() {

        while (matrix.getN() != fillerLatch.getCount()) {
            try {
                logger.debug(" starting of filling with locker");
                fillerLatch.fill(matrix, number);
            } catch (ServiceException e) {
                logger.debug(e.getMessage());
            }
            try {
                fillerLatch.getCountDown().await();
            } catch (InterruptedException e) {
                logger.error("InterruptedException in BarrierTread");
            } finally {
                logger.debug(" finishing of filling one element ");
            }

        }

    }
}
