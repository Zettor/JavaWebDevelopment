package by.ysenko.task4.dao.DOM;

import by.ysenko.task4.bean.Blossom;
import by.ysenko.task4.bean.Cactus;
import by.ysenko.task4.bean.Flower;
import by.ysenko.task4.bean.Liana;
import by.ysenko.task4.bean.tips.GrovingTips;
import by.ysenko.task4.bean.visual.BlossomVisualParameters;
import by.ysenko.task4.bean.visual.LianaVisualParameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FlowerDOMBuilder {
    private Set<Flower> flowers;
    private DocumentBuilder docBuilder;

    public FlowerDOMBuilder(String xsdPath) {
        this.flowers = new HashSet<Flower>();
        // создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        String constant = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory xsdFactory = SchemaFactory.newInstance(constant);
        Schema schema = null;
        try {
            schema = xsdFactory.newSchema(new File(xsdPath));
        } catch (SAXException e) {
            e.printStackTrace();
        }

        factory.setNamespaceAware(true);
        factory.setValidating(false);
        factory.setSchema(schema);
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<Flower> getStudents() {
        return flowers;
    }

    public void buildSetStudents(String fileName) {
        Document doc = null;
        try {
// parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <student>
            NodeList blossomList = root.getElementsByTagName("blossom");
            for (int i = 0; i < blossomList.getLength(); i++) {
                Element blossomElement = (Element) blossomList.item(i);
                Flower flower = buildFlower(blossomElement, "blossom");
                flowers.add(flower);
            }
            NodeList lianaList = root.getElementsByTagName("liana");
            for (int i = 0; i < lianaList.getLength(); i++) {
                Element lianaElement = (Element) lianaList.item(i);
                Flower flower = buildFlower(lianaElement, "liana");
                flowers.add(flower);
            }
            NodeList cactusList = root.getElementsByTagName("cactus");
            for (int i = 0; i < cactusList.getLength(); i++) {
                Element cactusElement = (Element) cactusList.item(i);
                Flower flower = buildFlower(cactusElement, "cactus");
                flowers.add(flower);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Flower buildFlower(Element flowerElement, String flowerName) {

        Flower flower;
        if (flowerName.equals("blossom")) {
            System.out.println("lblossom");
            flower = new Blossom();
        } else if (flowerName.equals("liana")) {
            System.out.println("liana");
            flower = new Liana();
        } else {
            System.out.println("Cactus");
            flower = new Cactus();
        }
        // заполнение объекта student
        flower.setId(Integer.parseInt(flowerElement.getAttribute("id").replace("id", "")));
        flower.setName(getElementTextContent(flowerElement, "name"));
        System.out.println(flower.getName());
        flower.setSoil(getElementTextContent(flowerElement, "soil"));
        flower.setOrigin(flowerElement.getAttribute("origin"));
        GrovingTips grovingTips = flower.getGrovingTips();
        // заполнение объекта address
        Element grovingTipsElement = (Element) flowerElement.getElementsByTagName(
                "growing_tips").item(0);
        grovingTips.setTemperature(Integer.parseInt(getElementTextContent(grovingTipsElement, "temperature")));
        grovingTips.setLighting(Boolean.valueOf(getElementTextContent(grovingTipsElement, "lighting")));
        grovingTips.setWatering(Double.parseDouble(getElementTextContent(grovingTipsElement, "watering")));
        flower.setMultiplying(getElementTextContent(flowerElement, "multiplying"));


        Element visualParametersElement = (Element) flowerElement.getElementsByTagName(
                "visual_parameters").item(0);
        flower.getVisualParameters().setStemColor(getElementTextContent(visualParametersElement, "stem_color"));
        flower.getVisualParameters().setSize(Double.parseDouble(getElementTextContent(visualParametersElement, "size")));

        if (flowerName.equals("blossom")) {
            ((BlossomVisualParameters) flower.getVisualParameters()).setLeafColor(getElementTextContent(visualParametersElement, "leaf_color"));
            ((Blossom) flower).setFruits(Boolean.valueOf(getElementTextContent(flowerElement, "fruits")));

        } else if (flowerName.equals("liana")) {
            ((LianaVisualParameters) flower.getVisualParameters()).setLeafType(getElementTextContent(visualParametersElement, "leaf_type"));
            ((Liana) flower).setType(getElementTextContent(flowerElement, "type"));
        } else {
            ((Cactus) flower).setSubfamily(getElementTextContent(flowerElement, "subfamily"));
        }
        return flower;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}