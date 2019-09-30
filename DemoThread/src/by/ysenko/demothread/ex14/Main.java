package by.ysenko.demothread.ex14;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(5);
        for (int i = 1; i <= 13; i++)
            new Philosopher(sem, i).start();
    }


}
