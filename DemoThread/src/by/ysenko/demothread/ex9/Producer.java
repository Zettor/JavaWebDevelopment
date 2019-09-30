package by.ysenko.demothread.ex9;


class Producer extends Thread {
    Store store; // объект склада, куда кладем товар
    int product = 5; // количество товаров, которые надо добавить

    Producer(Store store) {
        this.store = store;
    }

    public void run() {

        while (product > 0) { // пока у производителя имеются товары
            product = product - store.put(); // кладем один товар на склад
            System.out.println("производителю осталось произвести " + product + " товар(ов)");
            try {
                sleep(10);
            } catch (InterruptedException e) {
                System.out.println("KVA");
            }
        }
    }
}
