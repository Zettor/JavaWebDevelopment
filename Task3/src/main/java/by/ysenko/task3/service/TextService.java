package by.ysenko.task3.service;

import by.ysenko.task3.service.exception.ServiceException;

public interface TextService {

    /**
     * Method for reading text from file and adding it to storage.
     *
     * @param dataPath - path to file with data.
     * @param outPath  - path to file where text should be writing.
     * @throws ServiceException - when wrong path to file
     *                          with data or file for writing
     */
    void readText(String dataPath, String outPath) throws ServiceException;

    /**
     * Method for getting String text from storage.
     *
     * @param index - index of text for getting.
     * @return String text.
     * @throws ServiceException - when method get wrong index.
     */
    String getText(String index) throws ServiceException;

    /**
     * Method for sorting paragraphs in text by sentences.
     *
     * @param strIndex - index of text for sorting.
     * @return String sorting text.
     * @throws ServiceException - when method get wrong index.
     */
    String sortBySentence(String strIndex) throws ServiceException;

    /**
     * Method for sorting words in text by their length.
     *
     * @param strIndex - index of text for sorting.
     * @return String sorting text.
     * @throws ServiceException - when method get wrong index.
     */
    String sortByWord(String strIndex) throws ServiceException;

    /**
     * Method for sorting tokens in text by
     * count of some character in it or by alphabet.
     *
     * @param strIndex  - index of text for sorting.
     * @param character - character for sorting.
     * @return String sorting text.
     * @throws ServiceException - when method get wrong index.
     */
    String sortByToken(String strIndex, String character)
            throws ServiceException;
}
