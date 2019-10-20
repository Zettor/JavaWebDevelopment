package by.ysenko.task3.service.parsers;

import by.ysenko.task3.bean.Composite;
import by.ysenko.task3.bean.Letter;

public final class LetterParser implements Parser {

    @Override
    public void parse(final String str, final Composite composite) {


        char[] letters = str.toCharArray();

        for (char letter : letters) {
            composite.add(new Letter(letter));
        }
    }
}
