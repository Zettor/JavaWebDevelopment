package by.ysenko.demothread.ex20;

import java.util.Random;
import java.util.concurrent.Callable;

public class CalCallable {

    public static class CalcCallable implements Callable<Number> {
        @Override
        public Number call() throws Exception {
            Number res = new Random().nextGaussian(); // имитация вычислений
            return res;
        }
    }

}
