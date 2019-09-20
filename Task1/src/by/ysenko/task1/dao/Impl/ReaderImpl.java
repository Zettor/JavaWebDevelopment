package by.ysenko.task1.dao.Impl;

import by.ysenko.task1.dao.Reader;
import by.ysenko.task1.dao.exception.ReaderException;
import by.ysenko.task1.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {



    private Validator validator;

    public ReaderImpl() {
        validator = new Validator();
    }


    @Override
    public ArrayList<String> read(String path) throws ReaderException {

        String line;

        ArrayList<String> fileLines = new ArrayList<String>();
            try (BufferedReader file = new BufferedReader(new FileReader(path))) {



                while ((line = file.readLine()) != null) {

                        fileLines.add(line);
                }

            } catch (IOException ex) {
                throw new ReaderException("Method read() got wrong path");
            }

return fileLines;
    }
}


