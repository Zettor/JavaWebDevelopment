package by.ysenko.task3.dao.impl;


import by.ysenko.task3.dao.Writer;
import by.ysenko.task3.dao.exception.WriterException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterImpl implements Writer {

    /**
     * Method of writting data to file.
     *
     * @param path - path to file.
     * @param data - data in ArrayList.
     * @throws WriterException - exception in WriterImpl.
     */
    @Override
    public void write(final String path, final List<String> data)
            throws WriterException {

        File output = new File(path);

        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(output, true))) {

            for (String line : data) {
                bufferedWriter.write(line + "\n");
            }
            bufferedWriter.write("\n" + "\n");
        } catch (IOException ex) {
            throw new WriterException("Method write() got wrong path");
        }

    }
}
