package by.ysenko.task4.service.impl;

import by.ysenko.task4.service.validator.Validator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FlowerServiceImplTest {


    private static String STANDART_FILE="D:\\Курсы\\JavaWebDevelopment\\Task4\\out\\artifacts\\Task4_war_exploded\\upload\\flowers.xml";
    private static String WRONG_TYPE_FILE="D:\\Курсы\\JavaWebDevelopment\\Task4\\src\\main\\resources\\data\\flowers.txt";
    private static String WRONG_FILE="D:\\Курсы\\JavaWebDevelopment\\Task4\\src\\main\\resources\\data\\wrong_flowers.xml";
    private static String XSD_SCHEME="D:\\Курсы\\JavaWebDevelopment\\Task4\\out\\artifacts\\Task4_war_exploded\\upload\\flowers.xsd";

    @DataProvider(name = "DataForValidate")
    public Object[] createDataForValidate() {

        return new Object[][]{
                {WRONG_TYPE_FILE, "Input XML file!"},
                {WRONG_FILE, "Some mistake in XML file."},
                {STANDART_FILE, "valid"}
        };
    }

    @Test(dataProvider = "DataForValidate")
    public void testValidate(String path,String expected) {

        Assert.assertEquals(expected,Validator.validate("file:///" +path,XSD_SCHEME));
    }
}