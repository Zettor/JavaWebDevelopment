package by.yasenko.task2.service.impl;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.dao.Reader;
import by.yasenko.task2.dao.exception.ReaderException;
import by.yasenko.task2.dao.factory.DAOFactory;
import by.yasenko.task2.service.MatrixService;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.factory.MatrixFactory;
import by.yasenko.task2.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixServiceImpl implements MatrixService {

    ReentrantLock locker=new ReentrantLock();
    Condition condition=locker.newCondition();

    /**
     * Service Logger.
     */
    private final Logger LOGGER = LogManager.getLogger(MatrixServiceImpl.class);

    private static int count = 0;

    @Override
    public Matrix createMatrix(String path) {

        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        Reader reader = daoObjectFactory.getReader();
        ArrayList<String> data = new ArrayList<>();

        try {
            data = reader.read(path);
        } catch (ReaderException e) {
            LOGGER.error(e.getMessage());
            LOGGER.info("Program closing.");
            System.exit(0);
        }


        if (!Validator.validate(data)) {
            LOGGER.error("createMatrix() got wrong data!");
            LOGGER.info("Program closing.");
            System.exit(0);
        }
        return MatrixFactory.createMatrix(data);
    }

    @Override
    public String showMatrix(Matrix matrix) {

        int[][] temp = matrix.getMatrix();

        String response = "";

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                response += (temp[i][j] + " ");
            }
            response += "\n";
        }
        return response;
    }

    @Override
    public void fillDiagonalLock(Matrix matrix, int number) {

        locker.lock();

        if (count <= matrix.getN()-1 && count <= matrix.getM()-1) {
            matrix.getMatrix()[count][count] = number;
            count++;

            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else{
            LOGGER.info("The main diagonal is already filled.");
        }
        locker.unlock();
    }
}
