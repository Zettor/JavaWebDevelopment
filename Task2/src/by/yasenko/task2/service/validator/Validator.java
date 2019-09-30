package by.yasenko.task2.service.validator;

import java.util.ArrayList;

/**
 * This class for validating data.
 *
 * @author Alexander Ysenko
 * @version 1.0
 */
public final class Validator {

    private Validator() {
    }

    /**
     * String for checking natural numbers.
     */
    private static final String NATURAL_NUMBERS = "[0-9]+";

    /**
     * String for checking fractional numbers.
     */
    private static final String FRACTIONAL_NUMBERS = "[0-9]+.+[0-9]+";

    /**
     * String for checking numbers.
     */
    private static final String ALL_NUMBERS = "[0-9]+.+[0-9]+||[0-9]+";

    /**
     * Mathod for validating.
     *
     * @param lines - lines with data.
     * @return true if line is right.
     */
    public static boolean validate(final ArrayList<String> lines) {

        int m = lines.get(0).length();
        for (int i = 0; i < lines.size(); i++) {

            if (lines.get(i).length() != m) {

                return false;
            }

            String[] tokens = lines.get(i).split(" ");

            for (int j = 0; j < tokens.length; j++) {

                if (!tokens[j].matches(NATURAL_NUMBERS)
                        || (i == j && !tokens[j].equals("0"))) {
                    return false;
                }


            }
        }
        return true;
    }
}
