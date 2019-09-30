package by.ysenko.demothread.ex10;

class Producer extends Thread{//implements Runnable {

    Store store;

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 9; i++) {
            store.put();
        }
    }
}

