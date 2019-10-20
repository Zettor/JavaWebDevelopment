package by.ysenko.task3.service.specifications;

import by.ysenko.task3.bean.Component;
import by.ysenko.task3.bean.Storage;
import by.ysenko.task3.bean.Text;
import by.ysenko.task3.bean.Token;
import by.ysenko.task3.bean.exception.BeanException;
import by.ysenko.task3.service.comparators.TokenComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;


public final class SortByToken implements Specification {

    /**
     * RootLogger for logging events.
     */
   private Logger Logger = LogManager.getRootLogger();

    /**
     * Index of text in storage.
     */
    private int index;

    /**
     * Character for sorting tokens.
     */
    private String character;

    /**
     * Constructor for creation specification with index of text in storage.
     * @param index - index of text in storage.
     * @param character - character for sorting tokens.
     */
    public SortByToken(final int index, final String character) {
        this.index = index;
        this.character = character;
    }

    @Override
    public ArrayList<Component> querry() {
        Text text = Storage.getStorage().getText(index);
        ArrayList<Component> tokens = new ArrayList<>();
        try {
            tokens = text.getUnit(Token.class);
            tokens.sort(new TokenComparator(character));
        } catch (BeanException e) {
            Logger.error(e.getMessage());
        }

        return tokens;
    }
}
