package by.yasenko.task2.bean;

import java.util.ArrayList;

public final class Matrix {

    /**
     * Instance of Matrix class.
     */
    private final static Matrix instance = new Matrix();

    /**
     * Method for getting instance of Matrix class.
     *
     * @return instance field.
     */
    public static Matrix getInstance() {
        return instance;
    }

    private Matrix() {
    }

    /**
     * Two-dimensional array containing a matrix.
     */
    private int[][] matrix;

    /**
     * Number of rows.
     */
    private int n;

    /**
     * Number of columns.
     */
    private int m;

    /**
     * Method for matrix initialization.
     *
     * @param matrix - data for matrix initialization.
     */
    public void initMatrix(final ArrayList<int[]> matrix) {

        this.matrix = new int[matrix.size()][matrix.get(0).length];
        matrix.toArray(this.matrix);

        this.n = matrix.size();
        this.m = matrix.get(0).length;
    }

    /**
     * Method for getting number of rows.
     *
     * @return of rows.
     */
    public int getN() {
        return n;
    }

    /**
     * Method for getting number of columns.
     *
     * @return of columns.
     */
    public int getM() {
        return m;
    }

    /**
     * Method for getting array with matrix.
     *
     * @return matrix.
     */
    public int[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                str += (matrix[i][j] + " ");
            }
            str += "\n";
        }

        return str;
    }
}
