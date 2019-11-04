package by.ysenko.task4.dao.SAX;

import by.ysenko.task4.bean.*;
import by.ysenko.task4.bean.visual.BlossomVisualParameters;
import by.ysenko.task4.bean.visual.LianaVisualParameters;
import by.ysenko.task4.dao.FlowerEnum;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class FlowerHandle extends DefaultHandler {

    private Set<Flower> flowers;
    private Flower current = null;
    private FlowerEnum currentEnum = null;
    private EnumSet<FlowerEnum> withText;

    public FlowerHandle() {
        flowers = new HashSet<Flower>();
        withText = EnumSet.range(FlowerEnum.NAME, FlowerEnum.TYPE);
    }

    public Set<Flower> getFlowers() {
        return flowers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("blossom".equals(localName)) {
            current = new Blossom();
            current.setId(Integer.parseInt(attrs.getValue(0).replace("id", "")));
            current.setOrigin(attrs.getValue(1));
        } else if ("cactus".equals(localName)) {
            current = new Cactus();
            current.setId(Integer.parseInt(attrs.getValue(0).replace("id", "")));
            current.setOrigin(attrs.getValue(1));
        } else if ("liana".equals(localName)) {
            current = new Liana();
            current.setId(Integer.parseInt(attrs.getValue(0).replace("id", "")));
            current.setOrigin(attrs.getValue(1));
        } else {
            FlowerEnum temp = FlowerEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ("blossom".equals(localName) || "liana".equals(localName) || "cactus".equals(localName)) {
            flowers.add(current);
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();

        if (currentEnum != null && !s.equals("")) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case SOIL:
                    current.setSoil(s);
                    break;
                case TEMPERATURE:
                    current.getGrovingTips().setTemperature(Integer.parseInt(s));
                    break;
                case LIGHTING:
                    current.getGrovingTips().setLighting(Boolean.valueOf(s));
                    break;
                case WATERING:
                    current.getGrovingTips().setWatering(Double.parseDouble(s));
                    break;
                case MULTIPLYING:
                    current.setMultiplying(s);
                    break;
                case STEM_COLOR:
                    current.getVisualParameters().setStemColor(s);
                    break;
                case SIZE:
                    current.getVisualParameters().setSize(Double.valueOf(s));
                    break;
                default:
                    if (current.getClass() == Blossom.class) {
                        switch (currentEnum) {
                            case LEAF_COLOR:
                                ((BlossomVisualParameters) current.getVisualParameters()).setLeafColor(s);
                                break;
                            case FRUITS:
                                ((Blossom) current).setFruits(Boolean.valueOf(s));
                                break;
                            default:
                        }
                    } else if (current.getClass() == Liana.class) {
                        switch (currentEnum) {
                            case LEAF_TYPE:
                                ((LianaVisualParameters) current.getVisualParameters()).setLeafType(s);
                                break;
                            case TYPE:
                                ((Liana) current).setType(s);
                                break;
                            default:
                        }
                    } else if (current.getClass() == Cactus.class && currentEnum == FlowerEnum.SUBFAMILY) {
                        ((Cactus) current).setSubfamily(s);
                    }
            }
        }
    }
}
