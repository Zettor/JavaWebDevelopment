package by.ysenko.task1.service.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorTest {

    @DataProvider(name = "positiveDataForValidator")
    public Object[] createPositiveDataForValidator() {
        return new Object[][]{
                {"4,MP,3,6.57,5.67",true},
                {"3,MPasd,3.456,6.57,",true},
                {"7,MPSD,3.425,3,soft",true}
        };
    }

    @DataProvider(name = "negativeDataForValidator")
    public Object[] createNegativeDataForValidator() {
        return new Object[][]{
                {"4,MP,3.45,6.57,5.67,3.45,2.35",false},
                {"4.0,MP,3.45,6.57,5.67",false},
                {"4,MP2,3.45,6.57,5.67",false},
                {"4.0,MP,3,6.57,5.67",false},
                {"4,MP,3.4,6.5,soft",false},
                {"",false}

        };
    }

    @Test(description = "Positive scenary of the validate",
            dataProvider = "positiveDataForValidator")
    public void testPositiveValidate(String actual, boolean expected) {

        Assert.assertEquals(Validator.validate(actual),expected);
    }

    @Test(description = "Negative scenary of the validate",
            dataProvider = "negativeDataForValidator")
    public void testNegativeValidate(String actual, boolean expected) {

        Assert.assertEquals(Validator.validate(actual),expected);
    }
}