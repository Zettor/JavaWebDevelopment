package by.ysenko.demothread.hometask;

public class Matrix {

    private static int row = 0;

    private int[][] matrix;

    public Matrix(int n, int m) {
        matrix = new int[n][m];
    }

    public synchronized void fill(int number) {


        for (int j = 0; j < matrix[row].length; j++) {
            matrix[row][j] = number;
        }
        row++;
        if (row >= matrix.length)
            row = 0;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
