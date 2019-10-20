package by.ysenko.task3.service.impl;

import by.ysenko.task3.bean.Component;
import by.ysenko.task3.bean.Storage;
import by.ysenko.task3.bean.Text;
import by.ysenko.task3.dao.Reader;
import by.ysenko.task3.dao.Writer;
import by.ysenko.task3.dao.exception.ReaderException;
import by.ysenko.task3.dao.exception.WriterException;
import by.ysenko.task3.dao.factory.DAOFactory;
import by.ysenko.task3.service.TextService;
import by.ysenko.task3.service.parsers.LetterParser;
import by.ysenko.task3.service.parsers.TokenParser;
import by.ysenko.task3.service.parsers.WordParser;
import by.ysenko.task3.service.exception.ServiceException;
import by.ysenko.task3.service.parsers.ParagraphParser;
import by.ysenko.task3.service.parsers.Parser;
import by.ysenko.task3.service.parsers.SentenceParser;
import by.ysenko.task3.service.specifications.SortBySentence;
import by.ysenko.task3.service.specifications.SortByToken;
import by.ysenko.task3.service.specifications.SortByWord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public final class TextServiceImpl implements TextService {

    /**
     * RootLogger for logging events.
     */
    private final Logger Logger = LogManager.getRootLogger();

    /**
     * Storage for keeping texts.
     */
    private final Storage storage = Storage.getStorage();

    /**
     * Path to file for writing texts.
     */
    private static String outPath;

    @Override
    public void readText(final String dataPath, final String outPath)
            throws ServiceException {

        DAOFactory daoFactory = DAOFactory.getInstance();
        Reader reader = daoFactory.getReader();
        ArrayList<String> data = new ArrayList<>();
        try {
            data = reader.read(dataPath);
        } catch (ReaderException e) {
            Logger.error(e.getMessage());
            throw new ServiceException("Wrong path to data file");
        }
        String str = "";
        for (String line : data) {
            str += line;
        }
        Parser letterParser = new LetterParser();
        Parser wordParser = new WordParser(letterParser);
        Parser tokenParser = new TokenParser(wordParser);
        Parser sentenceParser = new SentenceParser(tokenParser);
        Parser paragraphParser = new ParagraphParser(sentenceParser);

        Text text = new Text();
        paragraphParser.parse(str, text);
        try {
            writeToFile(text, outPath);
            this.outPath = outPath;
        } catch (WriterException e) {
            Logger.error(e.getMessage());
            throw new ServiceException("Wrong path to output file");
        }
        storage.add(text);
    }


    @Override
    public String getText(final String strIndex) throws ServiceException {

        int index;

        try {
            index = Integer.parseInt(strIndex);

            if (storage.getList().isEmpty() || index < 0
                    || index >= storage.getList().size()) {
                throw new ServiceException("Index out of storage range");
            }
        } catch (NumberFormatException ex) {
            throw new ServiceException("Wrong format of index.", ex);
        }
        Text text = storage.getText(index);
        try {
            writeToFile(text, outPath);
        } catch (WriterException e) {
            Logger.error(e.getMessage());
        }
        return text.getString();
    }

    @Override
    public String sortBySentence(final String strIndex)
            throws ServiceException {

        int index;

        try {
            index = Integer.parseInt(strIndex);
            if (storage.getList().isEmpty() || index < 0
                    || index >= storage.getList().size()) {
                throw new ServiceException("Index out of storage range");
            }
        } catch (NumberFormatException ex) {
            throw new ServiceException("Wrong format of index.", ex);
        }

        Text text = storage.getText(index);
        ArrayList<Component> components = (text.querry(
                new SortBySentence(index)));
        Text temp = new Text();
        for (Component component : components) {
            temp.add(component);
        }
        try {
            writeToFile(temp, outPath);
        } catch (WriterException e) {
            Logger.error(e.getMessage());
        }
        return temp.getString();
    }

    @Override
    public String sortByWord(final String strIndex) throws ServiceException {

        int index;

        try {
            index = Integer.parseInt(strIndex);
            if (storage.getList().isEmpty() || index < 0
                    || index >= storage.getList().size()) {
                throw new ServiceException("Index out of storage range");
            }
        } catch (NumberFormatException ex) {
            throw new ServiceException("Wrong format of index.", ex);
        }

        Text text = storage.getText(index);
        ArrayList<Component> components = (text.querry(new SortByWord(index)));
        Text temp = new Text();
        for (Component component : components) {
            temp.add(component);
        }
        try {
            writeToFile(temp, outPath);
        } catch (WriterException e) {
            Logger.error(e.getMessage());
        }
        return temp.getString();
    }

    @Override
    public String sortByToken(final String strIndex, final String character)
            throws ServiceException {

        int index;

        try {
            index = Integer.parseInt(strIndex);
            if (storage.getList().isEmpty() || index < 0
                    || index >= storage.getList().size()) {
                throw new ServiceException("Index out of storage range");
            }
        } catch (NumberFormatException ex) {
            throw new ServiceException("Wrong format of index.", ex);
        }

        Text text = storage.getText(index);
        ArrayList<Component> components = (text.querry(
                new SortByToken(index, character)));
        Text temp = new Text();
        for (Component component : components) {
            temp.add(component);
        }

        try {
            writeToFile(temp, outPath);
        } catch (WriterException e) {
            Logger.error(e.getMessage());
        }
        return temp.getString();
    }

    /**
     * Method for writing text in file.
     *
     * @param text  - text for writing.
     * @param path - path to file for writing.
     * @throws WriterException - when method get wrong path.
     */
    public void writeToFile(final Text text, final String path)
            throws WriterException {


        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        Writer writer = daoObjectFactory.getWriter();
        ArrayList<String> lines = new ArrayList<>();
        lines.add(text.getString());
        writer.write(path, lines);

    }

}
