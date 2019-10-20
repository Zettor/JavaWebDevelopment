package by.ysenko.task3.service.parsers;

import by.ysenko.task3.bean.Composite;
import by.ysenko.task3.bean.Paragraph;

import java.util.ArrayList;
import java.util.Arrays;

public final class ParagraphParser implements Parser {

    /**
     * Delimeter for parsing text to paragraphs.
     */
    private final String delimeter = "\\s{3}|\t";

    /**
     * Next parser.
     */
    private Parser parser;

    /**
     * Constructor for creation parser with reference for next parser.
     * @param parser - next parser
     */
    public ParagraphParser(final Parser parser) {
        this.parser = parser;
    }


    @Override
    public void parse(final String str, final Composite composite) {

        String[] temp = str.split(delimeter);

        ArrayList<String> paragraphs = new ArrayList<>(Arrays.asList(temp));
        paragraphs.remove("");
        if (!paragraphs.isEmpty()) {
            for (String strParagraph : paragraphs) {
                Paragraph paragraph = new Paragraph();
                parser.parse(strParagraph, paragraph);
                composite.add(paragraph);
            }
        }


    }
}
