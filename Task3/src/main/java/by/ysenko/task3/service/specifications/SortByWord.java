package by.ysenko.task3.service.specifications;

import by.ysenko.task3.bean.Component;
import by.ysenko.task3.bean.Storage;
import by.ysenko.task3.bean.Text;
import by.ysenko.task3.bean.Sentence;
import by.ysenko.task3.bean.Word;
import by.ysenko.task3.bean.exception.BeanException;
import by.ysenko.task3.service.comparators.WordComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public final class SortByWord implements Specification {

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
     *
     * @param index - index of text in storage.
     */
    public SortByWord(final int index) {
        this.index = index;
    }

    @Override
    public ArrayList<Component> querry() {
        Text text = Storage.getStorage().getText(index);
        ArrayList<Component> sentences = new ArrayList<>();
        ArrayList<Component> words = new ArrayList<>();
        try {
            sentences = text.getUnit(Sentence.class);
            for (Component sentence : sentences) {
                ArrayList<Component> temp = sentence.getUnit(Word.class);
                Component end = temp.remove(temp.size() - 1);
                temp.sort(new WordComparator());
                temp.add(end);
                words.addAll(temp);
            }

        } catch (BeanException e) {
            Logger.error(e.getMessage());
        }

        return words;
    }
}
