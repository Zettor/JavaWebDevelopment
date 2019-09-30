package by.yasenko.task2.service;

import by.yasenko.task2.bean.Matrix;

import java.util.ArrayList;

public interface MatrixService {

    Matrix createMatrix(String path);

    String showMatrix(Matrix matrix);

    void fillDiagonalLock(Matrix matrix, int number);

}
