package by.yasenko.task2.service.validator;

import java.util.ArrayList;


public final class Validator {

    private Validator() {
    }

    /**
     * String for checking natural numbers.
     */
    private static final String NATURAL_NUMBERS = "[0-9]+";

    /**
     * String for checking positive numbers.
     */
    private static final String POSITIVE_NUMBERS = "[1-9]+";

    /**
     * Mathod for validating.
     *
     * @param lines - lines with data.
     * @return true if line is right.
     */
    public static boolean validate(final ArrayList<String> lines) {

        if (lines.size() < 2) {
            return false;
        }

        String[] numbers = lines.get(0).split(",");

        for (String number : numbers) {
            if (!number.matches(POSITIVE_NUMBERS)) {
                return false;
            }
        }

        int length = lines.get(1).length();

        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).length() != length) {
                return false;
            }

            String[] tokens = lines.get(i).split(" ");

            for (int j = 0; j < tokens.length; j++) {

                if (!tokens[j].matches(NATURAL_NUMBERS)
                        || (i == j + 1 && !tokens[j].equals("0"))) {
                    return false;
                }
            }
        }
        return true;
    }
}
