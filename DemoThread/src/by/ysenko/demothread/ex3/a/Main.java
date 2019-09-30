package by.ysenko.demothread.ex3.a;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new Person("Bob"));
            thread1.setPriority(Thread.MAX_PRIORITY);
            Thread thread2 = new Thread(new Person("Alice"));
            thread2.setPriority(Thread.MIN_PRIORITY);
            Thread thread3 = new Thread(new Person("Carl"));
            thread3.setPriority(Thread.NORM_PRIORITY);
            thread1.start();
            thread2.start();
            thread3.start();
        }
    }
}
