package by.yasenko.task2.service.factory;

import by.yasenko.task2.bean.Matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixFactory {

    public static Matrix createMatrix(ArrayList<String> lines) {
        String delimeter = " ";

        int n = lines.size();
        int m = lines.get(0).split(" ").length;

        ArrayList<int[]> matrix = new ArrayList<>();

        for (String line : lines) {

            String[] tokens = line.split(" ");
            int[] row = new int[m];

            int i = 0;
            for (String token : tokens) {

                row[i] = Integer.parseInt(token);
                i++;
            }
            matrix.add(row);

        }
        return new Matrix(n, m, matrix);
    }

}
