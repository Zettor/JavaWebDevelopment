package by.ysenko.demothread.ex1;

public class HelloWorldThread extends Thread {

    static int count = 0;

    public void run() {

        System.out.println(Thread.currentThread());
        System.out.println("Hello world!");
        ++count;
        if (count < 10) {
            HelloWorldThread helloWorldThread1 = new HelloWorldThread();
            helloWorldThread1.start();
        }

    }

}
