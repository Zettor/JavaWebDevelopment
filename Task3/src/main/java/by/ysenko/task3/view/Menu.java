package by.ysenko.task3.view;


import by.ysenko.task3.controller.Controller;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public final class Menu {

    /**
     * Сountry short name.
     */
    private static String country;

    /**
     * Language short name.
     */
    private static String language;

    /**
     * Object of Controller class.
     */
    private static Controller controller = new Controller();

    /**
     * Method for getting main menu and working with it.
     */
    public void getMainMenu() {

        Scanner in = new Scanner(System.in);
        langmenu:
        while (true) {
            System.out.println("1-English");
            System.out.println("2-Русский");
            String langChose = in.next();
            switch (langChose) {
                case "1":
                    country = "UK";
                    language = "en";
                    break langmenu;
                case "2":
                    country = "RU";
                    language = "ru";
                    break langmenu;
                default:
            }

        }

        Locale current = new Locale(language, country);

        ResourceBundle rb = ResourceBundle.getBundle(
                "properties.text", current);


        menu:
        while (true) {
            System.out.println("1-" + rb.getString("read_text"));
            System.out.println("2-" + rb.getString("get_text"));
            System.out.println("3-" + rb.getString("sort_by_sentence"));
            System.out.println("4-" + rb.getString("sort_by_word"));
            System.out.println("5-" + rb.getString("sort_by_token"));
            System.out.println("6-" + rb.getString("exit"));

            String choice = in.next();
            String temp;
            switch (choice) {
                case "1": {
                    System.out.println(rb.getString("entering_path_of_data"));
                    String dataPath = in.next();
                    System.out.println(rb.getString("entering_path_of_out"));
                    String outPath = in.next();
                    System.out.println(rb.getString(controller.executeTask(
                            "read_text " + dataPath + " " + outPath)));
                    break;
                }
                case "2": {
                    System.out.println(rb.getString("index_entering"));
                    String index = in.next();
                    temp = controller.executeTask("get_text " + index);
                    if (temp.equals("wrong_format")) {
                        System.out.println(rb.getString(temp));
                    } else {
                        System.out.println(temp);
                    }
                    break;
                }
                case "3": {
                    System.out.println(rb.getString("index_entering"));
                    String index = in.next();
                    temp = controller.executeTask("sort_by_sentence " + index);
                    if (temp.equals("wrong_format")) {
                        System.out.println(rb.getString(temp));
                    } else {
                        System.out.println(temp);
                    }
                    break;
                }

                case "4": {
                    System.out.println(rb.getString("index_entering"));
                    String index = in.next();
                    temp = controller.executeTask("sort_by_word " + index);
                    if (temp.equals("wrong_format")) {
                        System.out.println(rb.getString(temp));
                    } else {
                        System.out.println(temp);
                    }
                    break;
                }

                case "5": {
                    System.out.println(rb.getString("index_entering"));
                    String index = in.next();

                    System.out.println(rb.getString("character_entering"));
                    String character = in.next();

                    temp = controller.executeTask(
                            "sort_by_token " + index + " " + character);
                    if (temp.equals("wrong_format")) {
                        System.out.println(rb.getString(temp));
                    } else {
                        System.out.println(temp);
                    }
                    break;
                }
                case "6":
                    break menu;
                default:

            }
        }
    }
}
