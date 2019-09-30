package by.ysenko.demothread.ex12.b;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Store {
    private int product = 0;
    ReentrantLock locker;
    Condition condition1;
    Condition condition2;

    Store() {
        locker = new ReentrantLock(); // создаем блокировку
        condition1 = locker.newCondition(); // получаем условие, связанное с блокировкой
        condition2 = locker.newCondition();
    }

    public void get() {

        locker.lock();
        try {
            // пока нет доступных товаров на складе, ожидаем
            while (product < 1) {
                System.out.println("Покупатель засыпает");
                condition1.await();
            }
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);

            System.out.println("Будим производителя");
            condition2.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public void put() {

        locker.lock();
        try {
            // пока на складе 3 товара, ждем освобождения места
            while (product >= 3) {
                System.out.println("Производитель засыпает");
                condition2.await();
            }
            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
            // сигнализируем
            System.out.println("Будим покупателя");
            condition1.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}
