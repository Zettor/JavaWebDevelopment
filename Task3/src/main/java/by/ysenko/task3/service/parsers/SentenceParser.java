package by.ysenko.task3.service.parsers;

import by.ysenko.task3.bean.Composite;
import by.ysenko.task3.bean.Sentence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SentenceParser implements Parser {

    /**
     * Next parser.
     */
    private Parser parser;

    /**
     * Regex for parsing text to sentences.
     */
    private final String regex = "[^\\s][^\\.\\?\\!]*[\\.\\?\\!]+";

    /**
     * Constructor for creation parser with reference for next parser.
     *
     * @param parser - next parser
     */
    public SentenceParser(final Parser parser) {
        this.parser = parser;
    }

    @Override
    public void parse(final String str, final Composite composite) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            Sentence sentence = new Sentence();
            parser.parse(str.substring(matcher.start(),
                    matcher.end()), sentence);
            composite.add(sentence);

        }
    }
}
