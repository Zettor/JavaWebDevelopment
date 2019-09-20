package by.ysenko.task1.service.impl;


import by.ysenko.task1.bean.*;
import by.ysenko.task1.repository.CarRepositoryImpl;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.exception.ServiceException;
import by.ysenko.task1.service.factory.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CarServiceImplTest {

    private static final String STANDART_FILE = "D:\\Курсы\\JavaWebDevelopment\\" +
            "Task1\\tests\\data\\testOfSumNormal.txt";

    private static final String EMPTY_FILE = "D:\\Курсы\\JavaWebDevelopment\\" +
            "Task1\\tests\\data\\testOfSumEmpty.txt";

    private static final String ZEROES_FILE = "D:\\Курсы\\JavaWebDevelopment\\" +
            "Task1\\tests\\data\\testOfSumZeroes.txt";

    @DataProvider(name = "DataForBaggegeSum")
    public Object[] createDataForSumOfBaggege() {
        return new Object[][]{
                {STANDART_FILE, 5400.54},
                {EMPTY_FILE, 0.0},
                {ZEROES_FILE, 0.0}


        };
    }

    @DataProvider(name = "DataForAddingCars")
    public Object[] createDataForAddingCars() {

        ArrayList<Car> standart = new ArrayList<Car>();
        ArrayList<Car> empty = new ArrayList<Car>();

        standart.add(new Locomotive(4, "LPOX", 3.45, 6.57, 5.67));
        standart.add(new BaggageCar(8, "BRGR", 2000.23, 1500.12));
        standart.add(new Coach(12, "CPR", 3234.55, 49, TypeOfCoach.BUFFET));
        standart.add(new Coach(17, "CPZ", 3534.3, 42, TypeOfCoach.COMPARTMENT));
        standart.add(new Locomotive(21, "LASD", 2012.123, 4.567, 600.123));
        standart.add(new BaggageCar(7, "BRGR", 2320.13, 3900.42));
        return new Object[][]{
                {EMPTY_FILE, empty},
                {STANDART_FILE, standart}

        };
    }


    @Test(dataProvider = "DataForBaggegeSum", expectedExceptions = {ServiceException.class})
    public void testSumOfBaggage(String path, double expected) throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

            carService.addCars(path);


        Assert.assertEquals(carService.calcSumOfBaggage(), expected);

    }

    @Test
    public void testGetSumOfPassengersNormal() {


    }

    @Test
    public void testGetSumOfPassengersEmptyTrain() {


    }

    @Test
    public void testGetSumOfSpeedNormal() {

    }

    @Test
    public void testGetSumOfSpeedEptyTrain() {


    }

    @Test(dataProvider = "DataForAddingCars")
    public void testAddCars(String path,ArrayList<Car> expected)  {

        CarRepositoryImpl repository=CarRepositoryImpl.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();
        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.fail();
        }

        Assert.assertEquals(repository.getAll(),expected);
    }

    @Test
    public void testDeleteCar() {

    }

    @Test
    public void testSearchByName() {
    }

    @Test
    public void testSearchByPassengers() {
    }

    @Test
    public void testSearchByWeight() {
    }

    @Test
    public void testSortByName() {
    }

    @Test
    public void testSortByWeight() {
    }
}