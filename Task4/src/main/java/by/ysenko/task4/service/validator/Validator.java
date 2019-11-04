package by.ysenko.task4.service.validator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class Validator {

    static public String validate(String xmlPath, String xsdPath) {
        if(!xmlPath.substring(xmlPath.length()-4).equals(".xml")){
          return  "Input XML file!";
        }

        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
// установка проверки с использованием XSD
            schema = factory.newSchema(new File(xsdPath));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            spf.setValidating(false);
            spf.setSchema(schema);
// создание объекта-парсера
            SAXParser parser = spf.newSAXParser();
// установка обработчика ошибок и запуск
            parser.parse(xmlPath, new FlowerErrorHandler());


            return "valid";

        } catch (ParserConfigurationException e) {
            return"Some mistake in XML file.";
        } catch (SAXException e) {
            return"Some mistake in XML file.";
        } catch (IOException e) {
            return"Some mistake in XML file.";
        }
    }
}
