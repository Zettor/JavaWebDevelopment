package by.ysenko.demothread.ex9;

class Consumer extends Thread {
    Store store; // объект склада, с которого покупатель будет брать товар
    int product = 0; // текущее количество товаров со склада
    final int N = 5; // максимально допустимое число
    Consumer(Store store) {
        this.store = store;
    }

    public void run() {

            while (product < N) {// пока количество товаров не будет равно 5

                product = product + store.get(); // берем по одному товару со склада
                System.out.println("Потребитель купил " + product + " товар(ов)");
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("KVA2");
                }
            }

    }
}
