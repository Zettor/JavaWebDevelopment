package by.yasenko.task2.bean;

import java.util.ArrayList;

public class Matrix {

    private int[][] matrix;

    private int n;

    private int m;

    public Matrix(int n, int m, ArrayList<int[]> matrix) {

        this.matrix = new int[n][m];
        matrix.toArray(this.matrix);

        this.n=n;
        this.m=m;
        }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }


    public int[][] getMatrix() {
        return matrix;
    }

}
