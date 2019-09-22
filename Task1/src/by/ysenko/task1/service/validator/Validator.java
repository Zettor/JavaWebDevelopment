package by.ysenko.task1.service.validator;

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
     * String for checking natural names.
     */
    private static final String All_NAMES = "[a-zA-Z]+";

    /**
     * Mathod for validating.
     *
     * @param line - line with data.
     * @return true if line is right.
     */
    public static boolean validate(final String line) {

        String[] tokens = line.split(",");

        if (tokens.length != 4 && tokens.length != 5) {
            return false;
        }

        if (!tokens[0].matches(NATURAL_NUMBERS)) {
            return false;
        }

        if (!tokens[1].matches(All_NAMES)) {
            return false;
        }

        if (!tokens[2].matches(ALL_NUMBERS)) {
            return false;
        }

        if (!tokens[3].matches(ALL_NUMBERS)) {
            return false;
        }
        if (tokens.length == 5) {
            if (!tokens[4].matches(ALL_NUMBERS) && !tokens[4].equals("soft")
                    && !tokens[4].equals("buffet")
                    && !tokens[4].equals("compartment")) {
                return false;
            }

            if ((tokens[4].equals("soft")
                    || tokens[4].equals("buffet")
                    || tokens[4].equals("compartment"))
                    && !tokens[3].matches(NATURAL_NUMBERS)) {
                return false;
            }
        }


        return true;
    }

}
