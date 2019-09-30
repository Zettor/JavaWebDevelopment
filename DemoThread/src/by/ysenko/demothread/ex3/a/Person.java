package by.ysenko.demothread.ex3.a;

public class Person implements Runnable {

    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name + " said: Hello World!");
    }
}
