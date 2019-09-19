package by.ysenko.task1.view;

import by.ysenko.task1.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Menu {

    private static Controller controller = new Controller();

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
                case 1:
                    System.out.println(controller.executeTask("add_cars "));
                    break;
                case 2:
                    System.out.println("Enter the car index");
                    int index = in.nextInt();
                    System.out.println(controller.executeTask("delete_car " + index));
                    break;
                case 3:
                    System.out.println(controller.executeTask("get_all "));
                    break;
                case 4:
                    System.out.println(chooseSearch());
                    break;
                case 5:
                    System.out.println(chooseSort());
                    break;
                case 6:
                    System.out.println(chooseSum());
                    break;
                case 7:
                    break menu;

            }
        }
    }

    public String chooseSort() {

        String result = "";

        Scanner in = new Scanner(System.in);


        System.out.println("1 - Sort by name");
        System.out.println("2 - Sort by weight ");

        int choice = in.nextInt();

        switch (choice) {
            case 1:
                result = controller.executeTask("sort_by_name ");
                break;
            case 2:
                result = controller.executeTask("sort_by_weight ");
                break;
        }

        return result;
    }

    public String chooseSearch() {

        String result = "";

        Scanner in = new Scanner(System.in);


        System.out.println("1 - Search by name");
        System.out.println("2 - Search by passengers");
        System.out.println("3 - Search by weight ");

        int choice = in.nextInt();

        switch (choice) {
            case 1:

                System.out.println("Enter the car name");
                String name = in.next();
                result = controller.executeTask("search_by_name " + name);
                break;
            case 2:

                System.out.println("Enter the start number of passengers");
                int startP = in.nextInt();

                System.out.println("Enter the last number of passengers");
                int endP = in.nextInt();

                result = controller.executeTask("search_by_passengers " + startP + " " + endP);
                break;
            case 3:

                System.out.println("Enter the start car weight");
                double startW = in.nextDouble();

                System.out.println("Enter the last car weight");
                double endW = in.nextDouble();
                result = controller.executeTask("search_by_weight " + startW + " " + endW);
                break;
        }
        return result;
    }

    public String chooseSum() {

        String result = "";

        Scanner in = new Scanner(System.in);


        System.out.println("1 - Sum of baggage");
        System.out.println("2 - Sum of passengers");
        System.out.println("3 - Sum of speed");

        int choice = in.nextInt();

        switch (choice) {
            case 1:
                result = controller.executeTask("sum_baggage ");
                break;
            case 2:
                result = controller.executeTask("sum_passengers ");
                break;
            case 3:
                result = controller.executeTask("sum_speed ");
                break;
        }
        return result;
    }
}
