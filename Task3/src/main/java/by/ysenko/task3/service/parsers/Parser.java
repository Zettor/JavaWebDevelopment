package by.ysenko.task3.service.parsers;

import by.ysenko.task3.bean.Composite;

public interface Parser {

    /**
     * Method for parsing text to components.
     * @param str - part of String text.
     * @param composite - component for keeping other component.
     */
    void parse(String str, Composite composite);
}
