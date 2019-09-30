package by.ysenko.demothread.hometask;

public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(9, 3);
        FillerThread thread1 = new FillerThread(matrix);
        FillerThread thread2 = new FillerThread(matrix);
        FillerThread thread3 = new FillerThread(matrix);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        matrix.print();
    }
}
