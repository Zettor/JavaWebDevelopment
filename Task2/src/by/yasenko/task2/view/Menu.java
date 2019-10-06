package by.yasenko.task2.view;


import by.yasenko.task2.controller.Controller;

import java.util.Scanner;

public final class Menu {

    private static final String SHOW_MATRIX = "1";

    private static final String FILL_LOCK = "2";

    private static final String FILL_SEM = "3";

    private static final String FILL_BARRIER = "4";

    private static final String FILL_LATCH = "5";

    private static final String RESET_MATRIX = "6";

    private static final String EXIT = "7";

    /**
     * Object of Controller class.
     */
    private static Controller controller = new Controller();

    /**
     * Method for getting main menu and working with it.
     */
    public void getMainMenu() {

        Scanner in = new Scanner(System.in);

        String flag = "";
        String path = "";

        while (!flag.equals("Matrix initialized.")) {
            System.out.println("Enter path to file with data.");
            path = in.next();
            flag = controller.executeTask("init_matrix " + path);
            System.out.println(flag);
        }


        menu:
        while (true) {
            System.out.println("1 - Show matrix.");
            System.out.println("2 - Fill matrix's diagonal with locker.");
            System.out.println("3 - Fill matrix's diagonal with semaphore.");
            System.out.println("4 - Fill matrix's diagonal with barrier.");
            System.out.println("5 - Fill matrix's diagonal with latch.");
            System.out.println("6 - Reset matrix.");
            System.out.println("7 - Exit.");

            String choice = in.next();

            switch (choice) {
                case SHOW_MATRIX:
                    System.out.println(controller.executeTask("show_matrix "));
                    break;
                case FILL_LOCK:
                    System.out.println(controller.executeTask("fill_lock "));
                    break;
                case FILL_SEM:
                    System.out.println("Enter number of permits");
                    String permits = in.next();
                    System.out.println(controller.executeTask("fill_sem " + permits));
                    break;
                case FILL_BARRIER:
                    System.out.println(controller.executeTask("fill_barrier "));
                    break;
                case FILL_LATCH:
                    System.out.println(controller.executeTask("fill_latch "));
                    break;
                case RESET_MATRIX:
                    System.out.println(controller.executeTask("init_matrix " + path));
                    break;
                case EXIT:
                    break menu;
                default:

            }
        }
    }
}
