package by.ysenko.task4.service;

import by.ysenko.task4.bean.Flower;

import java.util.Set;

public interface FlowerService {

    Set<Flower> SAXExtractor(String xmlPath,String xsdPath);

    Set<Flower> DOMExtractor(String xmlPath,String xsdPath);

    Set<Flower> StAXExtractor(String xmlPath);

    String Validate(String xmlPath,String xsdPath);
}
