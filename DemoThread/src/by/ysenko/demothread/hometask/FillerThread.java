package by.ysenko.demothread.hometask;

public class FillerThread extends Thread {

    private static int count = 1;
    private final int number;

    Matrix matrix;

    FillerThread(Matrix matrix) {
        number = count++;
        this.matrix = matrix;
    }

    public void run() {
        for (int i = 0; i < 5; i++)
            matrix.fill(number);

    }

}
