package by.ysenko.task3.bean;

import java.util.ArrayList;

public final class Storage {

    /**
     * Static object of storage for creating general storage.
     */
    private static Storage storage = new Storage();

    /**
     * List of texts.
     */
    private ArrayList<Text> texts;

    private Storage() {
        texts = new ArrayList<>();
    }

    /**
     * Method for getting storage in other classes.
     *
     * @return storage object.
     */
    public static Storage getStorage() {
        return storage;
    }

    /**
     * Method for getting list of texts.
     *
     * @return list of texts.
     */
    public ArrayList<Text> getList() {
        return new ArrayList<>(texts);
    }

    /**
     * Method for getting text with special index.
     *
     * @param index of text for getting.
     * @return text with index.
     */
    public Text getText(final int index) {
        return texts.get(index);
    }

    /**
     * Method for adding text to storage.
     *
     * @param text - text for adding.
     */
    public void add(final Text text) {
        texts.add(text);
    }

    /**
     * Method for removing text from storage.
     *
     * @param index - index of text for removing.
     */
    public void delete(final int index) {
        texts.remove(index);
    }
}
