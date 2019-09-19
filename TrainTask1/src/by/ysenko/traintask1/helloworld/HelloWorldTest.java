package by.ysenko.traintask1.helloworld;

import org.testng.Assert;

import static by.ysenko.traintask1.helloworld.HelloWorld.sum;
import static org.testng.Assert.*;

public class HelloWorldTest {

    @org.testng.annotations.Test
    public void testSum() {
        Integer expected=3;

        Assert.assertEquals(sum(1,2),expected);
    }
}