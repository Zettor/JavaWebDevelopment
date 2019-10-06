package by.yasenko.task2.service.factory;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.service.exception.ServiceException;

import java.util.ArrayList;


public final class MatrixFactory {

    private MatrixFactory() {
    }

    /**
     * Method for matrix iinitialization.
     *
     * @param lines - arraylist with data.
     * @throws ServiceException - exception in Service layer
     */
    public static void createMatrix(final ArrayList<String> lines)
            throws ServiceException {

        Matrix matrix = Matrix.getInstance();

        String delimeter = " ";

        int n = lines.size();
        int m = lines.get(0).split(" ").length;

        ArrayList<int[]> numbers = new ArrayList<>();
        try {
            for (String line : lines) {

                String[] tokens = line.split(" ");
                int[] row = new int[m];

                int i = 0;
                for (String token : tokens) {

                    row[i] = Integer.parseInt(token);
                    i++;
                }
                numbers.add(row);

            }
            matrix.initMatrix(numbers);
        } catch (NumberFormatException ex) {
            throw new ServiceException("MatrixFactory's method"
                    + " got date of wrong format");
        }
    }

}
