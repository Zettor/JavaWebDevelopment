package by.ysenko.task3.service.comparators;

import by.ysenko.task3.bean.Component;

import java.util.Comparator;

public final class TokenComparator implements Comparator<Component> {

    /**
     * Character for sorting tokens.
     */
    private String character;

    /**
     * Constructor for creating comparator with character.
     *
     * @param character - character for sorting tokens.
     */
    public TokenComparator(final String character) {
        this.character = character;
    }

    @Override
    public int compare(final Component o1, final Component o2) {
        int num1 = o1.getString().length()
                - o1.getString().replace(character, "").length();

        int num2 = o2.getString().length()
                - o2.getString().replace(character, "").length();
        if (num1 == num2) {
            return o2.getString().toLowerCase().
                    compareTo(o1.getString().toLowerCase());
        }
        return num2 - num1;
    }
}
