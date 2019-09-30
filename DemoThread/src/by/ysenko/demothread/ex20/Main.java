package by.ysenko.demothread.ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        List<Future> list = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            list.add(es.submit(new CalCallable.CalcCallable()));


        es.shutdown();
        try {
            for (Future<Number> future : list)
                System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
