package by.ysenko.task1.dao.Impl;

import by.ysenko.task1.dao.Writer;
import by.ysenko.task1.dao.exception.WriterException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterImpl implements Writer {
    @Override
    public void write(String path, List<String> data) throws WriterException {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {

            for (String line : data) {
                bufferedWriter.write(line + "\n");
            }

        } catch (IOException ex) {
            throw new WriterException(ex);
        }

    }
}
