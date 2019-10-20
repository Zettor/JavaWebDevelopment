package by.ysenko.task3.service.comparators;

import by.ysenko.task3.bean.Component;

import java.util.Comparator;

public final class WordComparator implements Comparator<Component> {
    @Override
    public int compare(final Component o1, final Component o2) {

        int length1 = o1.getString().length();
        int length2 = o2.getString().length();
        return length1 - length2;
    }
}
