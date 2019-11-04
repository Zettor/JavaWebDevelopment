package by.ysenko.task4.dao.StAX;

import by.ysenko.task4.bean.Blossom;
import by.ysenko.task4.bean.Cactus;
import by.ysenko.task4.bean.Flower;
import by.ysenko.task4.bean.Liana;
import by.ysenko.task4.bean.tips.GrovingTips;
import by.ysenko.task4.bean.visual.BlossomVisualParameters;
import by.ysenko.task4.bean.visual.LianaVisualParameters;
import by.ysenko.task4.bean.visual.VisualParameters;
import by.ysenko.task4.dao.FlowerEnum;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FlowersStAXBuilder {
    private HashSet<Flower> flowers = new HashSet<>();
    private XMLInputFactory inputFactory;

    public FlowersStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();

    }

    public Set<Flower> getStudents() {
        return flowers;
    }

    public void buildSetStudents(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                Flower flower;
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.BLOSSOM) {
                        flower = buildFlower(reader, FlowerEnum.BLOSSOM);
                        flowers.add(flower);
                    } else if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.LIANA) {
                        flower = buildFlower(reader, FlowerEnum.LIANA);
                        flowers.add(flower);
                    } else if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.CACTUS) {
                        flower = buildFlower(reader, FlowerEnum.CACTUS);
                        flowers.add(flower);
                    }

                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }


    private Flower buildFlower(XMLStreamReader reader, FlowerEnum flowerName) throws XMLStreamException {
        Flower flower;
        switch (flowerName) {
            case BLOSSOM:
                flower = new Blossom();
                break;
            case LIANA:
                flower = new Liana();
                break;
            default:
                flower = new Cactus();
        }

        flower.setId(Integer.parseInt(reader.getAttributeValue(null, FlowerEnum.ID.getValue()).replace("id","")));

        if (reader.getAttributeCount() != 1) {
            flower.setOrigin(reader.getAttributeValue(null, FlowerEnum.ORIGIN.getValue()));
        } else {
            flower.setOrigin("USA");
        }
        // проверить на null

        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerEnum.valueOf(name.toUpperCase())) {

                        case NAME:
                            flower.setName(getXMLText(reader));
                            break;
                        case SOIL:
                            flower.setSoil(getXMLText(reader));
                            break;
                        case GROWING_TIPS:
                            flower.setGrovingTips(getXMLGrovingTips(reader));
                            break;
                        case VISUAL_PARAMETERS:
                            flower.setVisualParameters(getXMLVisualParameters(reader,flowerName));
                            break;
                        case MULTIPLYING:
                            flower.setMultiplying(getXMLText(reader));
                    }
                    if(flowerName==FlowerEnum.BLOSSOM){
                        if(FlowerEnum.FRUITS==FlowerEnum.valueOf(name.toUpperCase()))
                            ((Blossom)flower).setFruits(Boolean.valueOf(getXMLText(reader)));
                    } else if(flowerName==FlowerEnum.LIANA){
                        if(FlowerEnum.TYPE==FlowerEnum.valueOf(name.toUpperCase()))
                            ((Liana)flower).setType(getXMLText(reader));
                    }else if(flowerName==FlowerEnum.CACTUS){
                        if(FlowerEnum.SUBFAMILY==FlowerEnum.valueOf(name.toUpperCase()))
                            ((Cactus)flower).setSubfamily(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.BLOSSOM
                    || FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.LIANA
                    || FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.CACTUS ) {
                        return flower;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private GrovingTips getXMLGrovingTips(XMLStreamReader reader) throws XMLStreamException {
        GrovingTips grovingTips = new GrovingTips();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (FlowerEnum.valueOf(name.toUpperCase())) {
                        case TEMPERATURE:
                            grovingTips.setTemperature(Integer.parseInt(getXMLText(reader)));
                            break;
                        case LIGHTING:
                            grovingTips.setLighting(Boolean.valueOf(getXMLText(reader)));
                            break;
                        case WATERING:
                            grovingTips.setWatering(Double.parseDouble(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.GROWING_TIPS) {
                        return grovingTips;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }


    private VisualParameters getXMLVisualParameters(XMLStreamReader reader, FlowerEnum flowerName) throws XMLStreamException {
        VisualParameters visualParameters;
        switch (flowerName) {
            case BLOSSOM:
                visualParameters = new BlossomVisualParameters();
                break;
            case LIANA:
                visualParameters = new LianaVisualParameters();
                break;
            default:
                visualParameters = new VisualParameters();

        }

        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();

                    switch (FlowerEnum.valueOf(name.toUpperCase())) {
                        case STEM_COLOR:
                            visualParameters.setStemColor(getXMLText(reader));
                            break;
                        case SIZE:
                            visualParameters.setSize(Double.parseDouble(getXMLText(reader)));
                            break;
                    }

                    if(FlowerEnum.BLOSSOM==flowerName){
                        if(FlowerEnum.valueOf(name.toUpperCase())==FlowerEnum.LEAF_COLOR){
                            ((BlossomVisualParameters)visualParameters).setLeafColor(getXMLText(reader));
                        }
                    }
                    if(FlowerEnum.LIANA==flowerName){
                        if(FlowerEnum.valueOf(name.toUpperCase())==FlowerEnum.LEAF_TYPE){
                            ((LianaVisualParameters)visualParameters).setLeafType(getXMLText(reader));
                        }
                    }

                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (FlowerEnum.valueOf(name.toUpperCase()) == FlowerEnum.VISUAL_PARAMETERS) {
                        return visualParameters;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}


