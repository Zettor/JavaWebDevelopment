package by.ysenko.task1.service.specification;

import by.ysenko.task1.bean.Car;
import by.ysenko.task1.bean.Coach;
import by.ysenko.task1.bean.TypeOfCoach;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SearchByNameTest {


    @Test
    public void TestQuerry() {

        ArrayList<Car> actual = new ArrayList<>();
        actual.add(new Coach(4, "TPO", 3.23, 32, TypeOfCoach.BUFFET));
        actual.add(new Coach(2, "BpI", 5.13, 324, TypeOfCoach.SOFT));
        actual.add(new Coach(3, "BZKD", 5.13, 41, TypeOfCoach.SOFT));

        String name = "BpI";

        ArrayList<Car> expected = new ArrayList<>();
        expected.add(new Coach(2, "BpI", 5.13, 324, TypeOfCoach.SOFT));

        Assert.assertTrue(new SearchByName(name).querry(actual).equals(expected));
    }

}