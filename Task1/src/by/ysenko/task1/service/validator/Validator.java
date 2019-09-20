package by.ysenko.task1.service.validator;

public class Validator {

    private static final String NATURAL_NUMBERS = "[0-9]+";
    private static final String FRACTIONAL_NUMBERS = "[0-9]+.+[0-9]+";
    private static final String ALL_NUMBERS = "[0-9]+.+[0-9]+||[0-9]+";
    private static final String All_NAMES = "[a-zA-Z]+";

    public static boolean validate(String line) {

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
                    && !tokens[4].equals("buffet") && !tokens[4].equals("compartment")) {
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
