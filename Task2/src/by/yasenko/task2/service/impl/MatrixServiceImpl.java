package by.yasenko.task2.service.impl;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.dao.Reader;
import by.yasenko.task2.dao.exception.ReaderException;
import by.yasenko.task2.dao.factory.DAOFactory;
import by.yasenko.task2.service.MatrixService;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.factory.MatrixFactory;
import by.yasenko.task2.service.filler.impl.FillerLatch;
import by.yasenko.task2.service.filler.impl.FillerLock;
import by.yasenko.task2.service.thread.BarrierThread;
import by.yasenko.task2.service.thread.LatchThread;
import by.yasenko.task2.service.thread.LockThread;
import by.yasenko.task2.service.thread.SemThread;
import by.yasenko.task2.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public final class MatrixServiceImpl implements MatrixService {

    /**
     * Locker for filling methods.
     */
    private ReentrantLock locker = new ReentrantLock();

    /**
     * Service Logger.
     */
    private final Logger logger = LogManager.getLogger(MatrixServiceImpl.class);

    /**
     * Array with numbers for threads.
     */
    private int[] numbersOfThreads;

    @Override
    public void createMatrix(final String path) throws ServiceException {

        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        Reader reader = daoObjectFactory.getReader();
        ArrayList<String> data = new ArrayList<>();

        try {
            data = reader.read(path);
        } catch (ReaderException e) {
            logger.error(e.getMessage());
        }

        if (Validator.validate(data)) {
            String[] tokens = data.get(0).split(",");

            numbersOfThreads = new int[tokens.length];

            for (int i = 0; i < tokens.length; i++) {
                numbersOfThreads[i] = Integer.parseInt(tokens[i]);
            }
            data.remove(0);
            MatrixFactory.createMatrix(data);
        } else {
            throw new ServiceException();

        }


    }

    @Override
    public String showMatrix() {

        Matrix matrix = Matrix.getInstance();
        return matrix.toString();
    }

    @Override
    public void fillLock() throws ServiceException {

        Thread[] threads = new Thread[numbersOfThreads.length];


        FillerLock fillerLock = new FillerLock(locker);

        for (int i = 0; i < numbersOfThreads.length; i++) {
            threads[i] = new Thread(
                    new LockThread(fillerLock, numbersOfThreads[i]));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new ServiceException("InterruptedException"
                        + " in service fillLock()", e);
            }
        }
    }

    @Override
    public void fillSem(final int permits) throws ServiceException {


        if (permits <= 0 || permits > numbersOfThreads.length) {
            throw new ServiceException("fillSem got wrong number of permits");
        }

        Thread[] threads = new Thread[numbersOfThreads.length];
        Semaphore sem = new Semaphore(permits);
        logger.debug("permits in semaphore - " + permits);

        FillerLock fillerLock = new FillerLock(locker);

        for (int i = 0; i < numbersOfThreads.length; i++) {
            threads[i] = new Thread(new SemThread(fillerLock,
                    sem, numbersOfThreads[i]));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new ServiceException("InterruptedException"
                        + " in service fillLock()", e);
            }
        }
    }

    @Override
    public void fillBarrier() throws ServiceException {
        CyclicBarrier barrier =
                new CyclicBarrier(numbersOfThreads.length, new Runnable() {
                    public void run() {
                        logger.debug("Barrier open");
                    }
                });

        Thread[] threads = new Thread[numbersOfThreads.length];

        FillerLock fillerLock = new FillerLock(locker);

        for (int i = 0; i < numbersOfThreads.length; i++) {
            threads[i] = new Thread(new BarrierThread(fillerLock,
                    barrier, numbersOfThreads[i]));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new ServiceException("InterruptedException"
                        + " in service fillBarrier()", e);
            }
        }
    }

    @Override
    public void fillLatch() throws ServiceException {


        Thread[] threads = new Thread[numbersOfThreads.length];


        FillerLatch fillerLatch =
                new FillerLatch(locker, numbersOfThreads.length);

        for (int i = 0; i < numbersOfThreads.length; i++) {
            threads[i] = new Thread(new LatchThread(fillerLatch,
                    numbersOfThreads[i]));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new ServiceException("InterruptedException"
                        + " in service fillLatch()", e);
            }
        }
    }
}
