package by.ysenko.task3.service.specifications;

import by.ysenko.task3.bean.Component;
import by.ysenko.task3.bean.Paragraph;
import by.ysenko.task3.bean.Storage;
import by.ysenko.task3.bean.Text;
import by.ysenko.task3.bean.exception.BeanException;
import by.ysenko.task3.service.comparators.SentenceComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public final class SortBySentence implements Specification {

    /**
     * RootLogger for logging events.
     */
    private Logger Logger = LogManager.getRootLogger();

    /**
     * Index of text in storage.
     */
    private int index;

    /**
     * Constructor for creation specification with index of text in storage.
     * @param index - index of text in storage.
     */
    public SortBySentence(final int index) {
        this.index = index;
    }

    @Override
    public ArrayList<Component> querry() {
        Text text = Storage.getStorage().getText(index);
        ArrayList<Component> paragraphs = null;
        try {
            paragraphs = text.getUnit(Paragraph.class);
        } catch (BeanException e) {
            Logger.error(e.getMessage());
        }
        paragraphs.sort(new SentenceComparator());
        return paragraphs;
    }
}
