package by.ysenko.task3.service.parsers;

import by.ysenko.task3.bean.Composite;
import by.ysenko.task3.bean.Token;

import java.util.ArrayList;
import java.util.Arrays;

public final class TokenParser implements Parser {

    /**
     * Delimeter for parsing text to tokens.
     */
    private final String delimeter = "\\s";

    /**
     * Next parser.
     */
   private Parser parser;

    /**
     * Constructor for creation parser with reference for next parser.
     * @param parser - next parser
     */
    public TokenParser(final Parser parser) {
        this.parser = parser;
    }

    @Override
    public void parse(final String str, final Composite composite) {
        String[] temp = str.split(delimeter);

        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(temp));
        if (!tokens.isEmpty()) {
            for (String strToken : tokens) {
                Token token = new Token();
                parser.parse(strToken, token);
                composite.add(token);
            }
        }
    }
}
