package by.ysenko.demothread.ex2;

public class PersonThread extends Person implements Runnable {

    PersonThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name + " said: Hello World!");
    }
}
