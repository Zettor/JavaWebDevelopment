package by.ysenko.demothread.ex10;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Store {
    private int product = 0;

    ReentrantLock locker;

    Condition condition;

    public Store() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    public synchronized void put() {
        try {
            locker.lock();
            while (product >= 3) {
                condition.await();
            }
            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public synchronized void get() {
        locker.lock();
        try {
            while (product < 1)
                condition.await();
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}