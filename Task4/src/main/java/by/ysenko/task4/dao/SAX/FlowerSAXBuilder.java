package by.ysenko.task4.dao.SAX;

import by.ysenko.task4.bean.Flower;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class FlowerSAXBuilder {

    private Set<Flower> flowers;
    private FlowerHandle fh;
    private XMLReader reader;

    public FlowerSAXBuilder(String xsdPath) {
        // создание SAX-анализатора
        fh = new FlowerHandle();
        try {

            String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
            Schema schema = xsdFactory.newSchema(new File(xsdPath));


            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            spf.setValidating(false);
            spf.setSchema(schema);
            reader= spf.newSAXParser().getXMLReader();
           // reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(fh);
    } catch (SAXException | ParserConfigurationException e) {
        System.err.print("ошибка SAX парсера: " + e);
    }
}
    public Set<Flower> getStudents() {
        return flowers;
    }
    public void buildSetFlowers(String fileName) {
        try {
            // разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        flowers = fh.getFlowers();
    }
}
