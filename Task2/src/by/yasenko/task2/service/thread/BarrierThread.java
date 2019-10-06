package by.yasenko.task2.service.thread;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.filler.impl.FillerLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public final class BarrierThread implements Runnable {

    /**
     * Matrix.
     */
    private Matrix matrix;

    /**
     * Number of this thread for filling matrix.
     */
    private int number;

    /**
     * Object with method of filling matrix only with locker.
     */
    private FillerLock fillerLock;

    /**
     * Barrier for threads.
     */
    private CyclicBarrier barrier;

    /**
     * Logger for this class.
     */
    private final  Logger logger = LogManager.getLogger(LockThread.class);

    /**
     * Constructor - create a new object object
     * with the parameters indicated below.
     *
     * @param fillerLock - Object with method of filling matrix only with locker
     * @param barrier    - barrier for this thread
     * @param number      - number for this thread
     */
    public BarrierThread(final FillerLock fillerLock,
                         final CyclicBarrier barrier, final int number) {

        this.barrier = barrier;
        this.fillerLock = fillerLock;
        this.matrix = Matrix.getInstance();
        this.number = number;
    }

    @Override
    public void run() {

        while (matrix.getN() != fillerLock.getCount()) {
            try {
                logger.debug(" starting of filling with locker");
                fillerLock.fill(matrix, number);
            } catch (ServiceException e) {
                logger.debug(e.getMessage());
            }
            try {
                barrier.await();
            } catch (InterruptedException e) {
                logger.error("InterruptedException in BarrierThread");
            } catch (BrokenBarrierException e) {
                logger.error("BrokenBarrierException in BarrierThread");
            } finally {
                logger.debug(" finishing of filling one element ");
            }

        }

    }
}
