package by.ysenko.demothread.ex2;

public class Main {

    public static void main(String[] args) {

        for(int i=0;i<10;i++) {
           Thread thread1=new Thread( new PersonThread("Bob"));
            Thread thread2=new Thread( new PersonThread("Alice"));
            thread1.start();
            thread2.start();
        }

    }

}
