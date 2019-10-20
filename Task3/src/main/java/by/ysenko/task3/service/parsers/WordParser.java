package by.ysenko.task3.service.parsers;

import by.ysenko.task3.bean.Composite;
import by.ysenko.task3.bean.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WordParser implements Parser {

    /**
     * Regex for parsing text to words.
     */
    private final String regex = "[^\\,\\.\\:\\;\\?\\!]+|[\\,\\.\\;\\?\\!\\:]+";

    /**
     * Constructor for creation parser with reference for next parser.
     *
     * @param parser - next parser
     */
    public WordParser(final Parser parser) {
        this.parser = parser;
    }

    /**
     * Next parser.
     */
    private Parser parser;

    @Override
    public void parse(final String str, final Composite composite) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            Word word = new Word();
            parser.parse(str.substring(matcher.start(), matcher.end()), word);
            composite.add(word);

        }
    }
}
