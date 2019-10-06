package by.ysenko.demothread.ex22;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    private static final int NUMBER_BROKERS = 30;
    public static void main(String[ ] args) {
        Market market = new Market(new AtomicLong(100));
        market.start();
        for (int i = 0; i < NUMBER_BROKERS; i++) {
            new Broker(market).start();
        }
    }
}
