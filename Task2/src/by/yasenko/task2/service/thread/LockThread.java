package by.yasenko.task2.service.thread;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.service.MatrixService;
import by.yasenko.task2.service.impl.MatrixServiceImpl;

public class LockThread implements Runnable {


    private Matrix matrix;

    private int number;

    public LockThread(Matrix matrix, int number) {

        this.matrix = matrix;
        this.number = number;
    }

    @Override
    public void run() {


        MatrixService matrixService = new MatrixServiceImpl();

        for(int i=0;i<matrix.getN();i++)
        matrixService.fillDiagonalLock(matrix, number);

    }
}
