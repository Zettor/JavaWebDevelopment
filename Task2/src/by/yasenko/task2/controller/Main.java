package by.yasenko.task2.controller;

import by.yasenko.task2.bean.Matrix;
import by.yasenko.task2.service.MatrixService;
import by.yasenko.task2.service.impl.MatrixServiceImpl;
import by.yasenko.task2.service.thread.LockThread;

public class Main {
    private final static String PATH = "D:\\Курсы\\JavaWebDevelopment\\Task2\\src\\data.txt";


    public static void main(String[] args) {
        MatrixService matrixService = new MatrixServiceImpl();

        Matrix matrix = matrixService.createMatrix(PATH);

        Thread thread1 = new Thread(new LockThread(matrix, 9));
        Thread thread2 = new Thread(new LockThread(matrix, 1));
        Thread thread3 = new Thread(new LockThread(matrix, 6));

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

        System.out.println(matrixService.showMatrix(matrix));
    }
}
