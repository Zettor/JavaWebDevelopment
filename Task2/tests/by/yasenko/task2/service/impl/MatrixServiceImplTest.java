package by.yasenko.task2.service.impl;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.service.MatrixService;
import by.yasenko.task2.service.exception.ServiceException;
import by.yasenko.task2.service.factory.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class MatrixServiceImplTest {

    private final static String STANDART_FILE = "tests//data//standart.txt";

    private final static String NOT_SQUARE_MATRIX_FILE = "tests//data//not_square_matrix.txt";

    private final static String EMPTY_FILE = "tests//data//empty.txt";

    private final static String EMPTY_MATRIX_FILE = "tests//data//empty_matrix.txt";

    private final static String EMPTY_THREADS_FILE = "tests//data//empty_threads.txt";

    private final static String NEGATIVE_MATRIX_FILE = "tests//data//negative_matrix.txt";

    private final static String NEGATIVE_THREADS_FILE = "tests//data//negative_threads.txt";

    private final static String NOT_ZERO_DIAGONAL_FILE = "tests//data//not_zero_diagonal.txt";

    private final static String ZERO_THREAD_FILE = "tests//data//zero_thread.txt";

    private final static String ONE_THREAD_STANDART_FILE="tests//data//one_thread_standart.txt";

    private final static String ONE_THREAD_NOT_STANDART_FILE="tests//data//one_thread_not_standart.txt";


    @DataProvider(name = "PositiveDataForCreateMatrix")
    public Object[] createPositiveDataForCreateMatrix() {

        int[][] standart = {{0, 2, 4, 4, 3}, {2, 0, 1, 8, 7}, {3, 5, 0, 3, 1}, {4, 1, 6, 0, 2}, {3, 7, 2, 1, 0}};
        int[][] nonStandart = {{0, 2, 4, 4, 3, 4}, {2, 0, 1, 8, 7, 2}, {3, 5, 0, 3, 1, 8}, {4, 1, 6, 0, 2, 1}, {3, 7, 2, 1, 0, 5}};

        return new Object[][]{
                {STANDART_FILE, standart},
                {NOT_SQUARE_MATRIX_FILE, nonStandart}
        };
    }

    @DataProvider(name = "NegativeDataForCreateMatrix")
    public Object[] createNegativeDataForCreateMatrix() {

        return new Object[][]{
                {EMPTY_FILE},
                {EMPTY_MATRIX_FILE},
                {EMPTY_THREADS_FILE},
                {NEGATIVE_MATRIX_FILE},
                {NEGATIVE_THREADS_FILE},
                {NOT_ZERO_DIAGONAL_FILE},
                {ZERO_THREAD_FILE},
                {"Wrong path"}
        };
    }

    @DataProvider(name = "DataForShowMatrix")
    public Object[] createDataForShowMatrix() {

        String standart = "0 2 4 4 3 \n" +
                "2 0 1 8 7 \n" +
                "3 5 0 3 1 \n" +
                "4 1 6 0 2 \n" +
                "3 7 2 1 0 \n";

        String nonStandart="0 2 4 4 3 4 \n" +
                "2 0 1 8 7 2 \n" +
                "3 5 0 3 1 8 \n" +
                "4 1 6 0 2 1 \n" +
                "3 7 2 1 0 5 \n";

        return new Object[][]{
                {STANDART_FILE, standart},
                {NOT_SQUARE_MATRIX_FILE, nonStandart}
        };
    }

    @DataProvider(name = "DataForFillingDiagonal")
    public Object[] createDataForFillingMatrix() {
        int[][] standart = {{1, 2, 4, 4, 3}, {2, 1, 1, 8, 7}, {3, 5, 1, 3, 1}, {4, 1, 6, 1, 2}, {3, 7, 2, 1, 1}};
        int[][] nonStandart = {{5, 2, 4, 4, 3, 4}, {2, 5, 1, 8, 7, 2}, {3, 5, 5, 3, 1, 8}, {4, 1, 6, 5, 2, 1}, {3, 7, 2, 1, 5, 5}};


        return new Object[][]{
                {ONE_THREAD_STANDART_FILE, standart},
                {ONE_THREAD_NOT_STANDART_FILE, nonStandart}
        };
    }

    @DataProvider(name = "PositiveDataForFillSem")
    public Object[] createPositiveDataForFillSem() {
        int[][] standart = {{1, 2, 4, 4, 3}, {2, 1, 1, 8, 7}, {3, 5, 1, 3, 1}, {4, 1, 6, 1, 2}, {3, 7, 2, 1, 1}};
        int[][] nonStandart = {{5, 2, 4, 4, 3, 4}, {2, 5, 1, 8, 7, 2}, {3, 5, 5, 3, 1, 8}, {4, 1, 6, 5, 2, 1}, {3, 7, 2, 1, 5, 5}};


        return new Object[][]{
                {ONE_THREAD_STANDART_FILE,1, standart},
                {ONE_THREAD_NOT_STANDART_FILE,1, nonStandart}
        };
    }

    @DataProvider(name = "NegativeDataForFillSem")
    public Object[] createNegativeDataForFillSem() {

        return new Object[][]{
                {STANDART_FILE,23},
                {STANDART_FILE,0},
                {STANDART_FILE,-23}
        };
    }

    @Test(dataProvider = "PositiveDataForCreateMatrix")
    public void testCreateMatrixPositive(String path, int[][] expected) throws ServiceException {

        Matrix matrix = Matrix.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        matrixService.createMatrix(path);

        Assert.assertEquals(matrix.getMatrix(), expected);
    }

    @Test(dataProvider = "NegativeDataForCreateMatrix")
    public void testCreateMatrixNegative(String path) {

        Matrix matrix = Matrix.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        assertThrows(ServiceException.class, () -> {
            matrixService.createMatrix(path);
        });
    }

    @Test(dataProvider = "DataForShowMatrix")
    public void testShowMatrix(String path, String expected) throws ServiceException {
        Matrix matrix = Matrix.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        matrixService.createMatrix(path);

        Assert.assertEquals(matrix.toString(), expected);
    }

    @Test(dataProvider = "DataForFillingDiagonal")
    public void testFillLock(String path,int[][]expected) throws ServiceException {

        Matrix matrix = Matrix.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        matrixService.createMatrix(path);

        matrixService.fillLock();

        Assert.assertEquals(matrix.getMatrix(), expected);
    }

    @Test(dataProvider = "PositiveDataForFillSem")
    public void testFillSemPositive(String path,int permits,int[][]expected) throws ServiceException {

        Matrix matrix = Matrix.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        matrixService.createMatrix(path);

        matrixService.fillSem(permits);

        Assert.assertEquals(matrix.getMatrix(), expected);
    }

    @Test(dataProvider = "NegativeDataForFillSem")
    public void testFillSemNegative(String path,int permits) throws ServiceException {

        Matrix matrix = Matrix.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        matrixService.createMatrix(path);

        assertThrows(ServiceException.class, () -> {
            matrixService.fillSem(permits);
        });

    }

    @Test(dataProvider = "DataForFillingDiagonal")
    public void testFillBarrier(String path,int[][]expected) throws ServiceException {

        Matrix matrix = Matrix.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        matrixService.createMatrix(path);

        matrixService.fillBarrier();

        Assert.assertEquals(matrix.getMatrix(), expected);
    }
    
    @Test(dataProvider = "DataForFillingDiagonal")
    public void testFillLatch(String path,int[][]expected) throws ServiceException {

        Matrix matrix = Matrix.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixService matrixService = serviceFactory.getMatrixService();

        matrixService.createMatrix(path);

        matrixService.fillLatch();

        Assert.assertEquals(matrix.getMatrix(), expected);
    }
}