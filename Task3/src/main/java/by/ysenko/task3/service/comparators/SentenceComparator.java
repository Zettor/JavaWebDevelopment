package by.ysenko.task3.service.comparators;

import by.ysenko.task3.bean.Component;
import by.ysenko.task3.bean.Sentence;
import by.ysenko.task3.bean.exception.BeanException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public final class SentenceComparator implements Comparator<Component> {

    /**
     * RootLogger for logging events.
     */
    private final Logger Logger = LogManager.getRootLogger();

    @Override
    public int compare(final Component o1, final Component o2) {

        try {
            int size1 = o1.getUnit(Sentence.class).size();
            int size2 = o2.getUnit(Sentence.class).size();
            return size1 - size2;
        } catch (BeanException e) {
            Logger.error(e.getMessage());
            return 0;
        }
    }
}
