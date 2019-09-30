package by.ysenko.demothread.ex10;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Consumer consumer = new Consumer(store);
        consumer.start();
        Producer producer = new Producer(store);
        producer.start();

        try {
            consumer.join();

            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
