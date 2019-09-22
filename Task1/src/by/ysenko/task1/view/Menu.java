package by.ysenko.task1.view;

import by.ysenko.task1.controller.Controller;


import java.util.Scanner;

public final class Menu {

    /**
     * One of main menu item.
     */
    private static final int FILL_TRAIN = 1;
    /**
     * One of main menu item.
     */
    private static final int DELETE_CAR = 2;
    /**
     * One of main menu item.
     */
    private static final int SHOW_TRAIN = 3;
    /**
     * One of main menu item.
     */
    private static final int SEARCH_MENU = 4;
    /**
     * One of main menu item.
     */
    private static final int SORT_MENU = 5;
    /**
     * One of main menu item.
     */
    private static final int SUM_MENU = 6;
    /**
     * One of main menu item.
     */
    private static final int EXIT = 7;

    /**
     * One of sort menu item.
     */
    private static final int SORT_BY_NAME = 1;
    /**
     * One of sort menu item.
     */
    private static final int SORT_BY_WEIGHT = 2;

    /**
     * One of search menu item.
     */
    private static final int SEARCH_BY_NAME = 1;

    /**
     * One of search menu item.
     */
    private static final int SEARCH_BY_PASSENGERS = 2;

    /**
     * One of search menu item.
     */
    private static final int SEARCH_BY_WEIGHT = 3;

    /**
     * One of sum menu item.
     */
    private static final int SUM_OF_BAGGAGE = 1;
    /**
     * One of sum menu item.
     */
    private static final int SUM_OF_PASSENGERS = 2;
    /**
     * One of sum menu item.
     */
    private static final int SUM_OF_SPEED = 3;

    /**
     * Object of Controller class.
     */
    private static Controller controller = new Controller();

    /**
     * Method for getting main menu and working with it.
     */
    public void getMainMenu() {
        menu:
        while (true) {
            System.out.println("1 - Fill train");
            System.out.println("2 - Delete car from train");
            System.out.println("3 - Show train");
            System.out.println("4 - Go to SearchMenu");
            System.out.println("5 - Go to SortMenu");
            System.out.println("6 - Go to SumMenu");
            System.out.println("7 - Exit");

            Scanner in = new Scanner(System.in);

            int choice = in.nextInt();

            switch (choice) {
                case FILL_TRAIN:
                    System.out.println(controller.executeTask("add_cars "));
                    break;
                case DELETE_CAR:
                    System.out.println("Enter the car index");
                    int index = in.nextInt();
                    System.out.println(controller.
                            executeTask("delete_car " + index));
                    break;
                case SHOW_TRAIN:
                    System.out.println(controller.executeTask("get_all "));
                    break;
                case SEARCH_MENU:
                    System.out.println(chooseSearch());
                    break;
                case SORT_MENU:
                    System.out.println(chooseSort());
                    break;
                case SUM_MENU:
                    System.out.println(chooseSum());
                    break;
                case EXIT:
                    break menu;
                default:

            }
        }
    }

    /**
     * Method for getting sort menu and working with it.
     *
     * @return response to user
     */
    public String chooseSort() {

        String result = "";

        Scanner in = new Scanner(System.in);


        System.out.println("1 - Sort by name");
        System.out.println("2 - Sort by weight ");

        int choice = in.nextInt();

        switch (choice) {
            case SORT_BY_NAME:
                result = controller.executeTask("sort_by_name ");
                break;
            case SORT_BY_WEIGHT:
                result = controller.executeTask("sort_by_weight ");
                break;
            default:
        }

        return result;
    }

    /**
     * Method for getting search menu and working with it.
     *
     * @return response to user
     */
    public String chooseSearch() {

        String result = "";

        Scanner in = new Scanner(System.in);


        System.out.println("1 - Search by name");
        System.out.println("2 - Search by passengers");
        System.out.println("3 - Search by weight ");

        int choice = in.nextInt();

        switch (choice) {
            case SEARCH_BY_NAME:

                System.out.println("Enter the car name");
                String name = in.next();
                result = controller.executeTask("search_by_name " + name);
                break;
            case SEARCH_BY_PASSENGERS:

                System.out.println("Enter the start number of passengers");
                int startP = in.nextInt();

                System.out.println("Enter the last number of passengers");
                int endP = in.nextInt();

                result = controller.executeTask("search_by_passengers "
                        + startP + " " + endP);
                break;
            case SEARCH_BY_WEIGHT:

                System.out.println("Enter the start car weight");
                double startW = in.nextDouble();

                System.out.println("Enter the last car weight");
                double endW = in.nextDouble();
                result = controller.executeTask("search_by_weight "
                        + startW + " " + endW);
                break;

            default:
        }
        return result;
    }

    /**
     * Method for getting sum menu and working with it.
     *
     * @return response to user
     */
    public String chooseSum() {

        String result = "";

        Scanner in = new Scanner(System.in);


        System.out.println("1 - Sum of baggage");
        System.out.println("2 - Sum of passengers");
        System.out.println("3 - Sum of speed");

        int choice = in.nextInt();

        switch (choice) {
            case SUM_OF_BAGGAGE:
                result = controller.executeTask("sum_baggage ");
                break;
            case SUM_OF_PASSENGERS:
                result = controller.executeTask("sum_passengers ");
                break;
            case SUM_OF_SPEED:
                result = controller.executeTask("sum_speed ");
                break;
            default:
        }
        return result;
    }
}
