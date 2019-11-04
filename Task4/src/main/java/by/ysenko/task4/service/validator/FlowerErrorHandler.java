package by.ysenko.task4.service.validator;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class FlowerErrorHandler extends DefaultHandler {
    // создание регистратора ошибок для пакета by.bsu.valid
    private Logger logger= LogManager.getRootLogger();
    public FlowerErrorHandler() throws IOException {
// установка файла и формата вывода ошибок
    }
    public void warning(SAXParseException e) {
        logger.warn(getLineAddress(e) + "-" + e.getMessage());
    }
    public void error(SAXParseException e) {
        logger.error(getLineAddress(e) + " - " + e.getMessage());
    }
    public void fatalError(SAXParseException e) {
        logger.fatal(getLineAddress(e) + " - " + e.getMessage());
    }
    private String getLineAddress(SAXParseException e) {
// определение строки и столбца ошибки
        return e.getLineNumber() + " : " + e.getColumnNumber();
    }
}