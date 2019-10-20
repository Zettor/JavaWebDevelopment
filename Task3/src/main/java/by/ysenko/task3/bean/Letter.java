package by.ysenko.task3.bean;

import by.ysenko.task3.bean.exception.BeanException;

import java.util.ArrayList;

public final class Letter implements Component {

    /**
     * Letter.
     */
    private char letter;

    /**
     * Constructor for creating object for keeping one character.
     * @param letter for keeping.
     */
    public Letter(final char letter) {
        this.letter = letter;
    }

    @Override
    public void add(final Component component) throws BeanException {
        throw new BeanException("Trying to use the method add() in Letter.");
    }

    @Override
    public void remove(final int index) throws BeanException {
        throw new BeanException("Trying to use the method remove() in Letter.");
    }

    @Override
    public Component getComponent(final int index) throws BeanException {
        if (true) {
            throw new BeanException("Trying to use the"
                    + " method getCompanent() in Letter.");
        }
        return null;
    }

    @Override
    public String getString() {
        return "" + letter;
    }

    @Override
    public ArrayList<Component> getUnit(final Class myClass)
            throws BeanException {
        if (true) {
            throw new BeanException("Trying to use the"
                    + " method getUnit() in Letter.");
        }
        return null;
    }
}
