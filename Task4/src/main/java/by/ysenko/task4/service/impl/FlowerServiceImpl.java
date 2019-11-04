package by.ysenko.task4.service.impl;

import by.ysenko.task4.bean.Flower;
import by.ysenko.task4.dao.DOM.FlowerDOMBuilder;
import by.ysenko.task4.dao.SAX.FlowerSAXBuilder;
import by.ysenko.task4.dao.StAX.FlowersStAXBuilder;
import by.ysenko.task4.service.FlowerService;
import by.ysenko.task4.service.validator.Validator;

import java.util.HashSet;
import java.util.Set;

public class FlowerServiceImpl implements FlowerService {
    @Override
    public Set<Flower> SAXExtractor(String xmlPath, String xsdPath) {
        FlowerSAXBuilder saxBuilder = new FlowerSAXBuilder(xsdPath);
        saxBuilder.buildSetFlowers(xmlPath);
        return saxBuilder.getStudents();



    }

    @Override
    public Set<Flower> StAXExtractor(String xmlPath) {
        FlowersStAXBuilder flowerStAXBuilder = new FlowersStAXBuilder();
        flowerStAXBuilder.buildSetStudents(xmlPath);
        return flowerStAXBuilder.getStudents();
    }

    @Override
    public Set<Flower> DOMExtractor(String xmlPath, String xsdPath) {
        FlowerDOMBuilder flowerDOMBuilder = new FlowerDOMBuilder(xsdPath);
        flowerDOMBuilder.buildSetStudents(xmlPath);
        return flowerDOMBuilder.getStudents();

    }

    @Override
    public String Validate(String xmlPath, String xsdPath) {
        return Validator.validate(xmlPath, xsdPath);
    }


}
