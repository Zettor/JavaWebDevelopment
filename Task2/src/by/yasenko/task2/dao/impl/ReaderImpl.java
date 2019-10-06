package by.yasenko.task2.dao.impl;

import by.yasenko.task2.dao.Reader;
import by.yasenko.task2.dao.exception.ReaderException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderImpl implements Reader {

    /**
     * Method of getting data from file.
     *
     * @param path - path to file.
     * @return ArrayList of String's with data.
     */
    @Override
    public ArrayList<String> read(final String path) throws ReaderException{

        String line;

        ArrayList<String> fileLines = new ArrayList();
        try (BufferedReader file
                     = new BufferedReader(new FileReader(path))) {


            while ((line = file.readLine()) != null) {

                fileLines.add(line);
            }

        } catch (IOException ex) {
            throw new ReaderException("Method read() got wrong path");
        }

        return fileLines;
    }
}


