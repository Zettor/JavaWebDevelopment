package by.ysenko.task1.service.impl;


import by.ysenko.task1.bean.*;
import by.ysenko.task1.repository.CarRepositoryImpl;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.exception.ServiceException;
import by.ysenko.task1.service.factory.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImplTest {

    private static final String STANDART_FILE = "D:\\Курсы\\JavaWebDevelopment\\" +
            "Task1\\tests\\data\\testNormal.txt";

    private static final String EMPTY_FILE = "D:\\Курсы\\JavaWebDevelopment\\" +
            "Task1\\tests\\data\\testEmpty.txt";

    private static final String ZEROES_FILE = "D:\\Курсы\\JavaWebDevelopment\\" +
            "Task1\\tests\\data\\testZeroes.txt";

    @BeforeMethod
    public void resetTrain() {
        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        ArrayList<Car> train = repository.getAll();
        if (!train.isEmpty()) {
            for (int i = train.size() - 1; i >= 0; i--) {
                repository.deleteCar(i);
            }
        }
    }

    @DataProvider(name = "DataForBaggegeSum")
    public Object[] createDataForSumOfBaggege() {
        return new Object[][]{
                {EMPTY_FILE, 0.0},
                {ZEROES_FILE, 0.0},
                {STANDART_FILE, 5400.54}
        };
    }

    @DataProvider(name = "DataForPassengersSum")
    public Object[] createDataForSumOfPassengers() {
        return new Object[][]{
                {EMPTY_FILE, 0},
                {ZEROES_FILE, 0},
                {STANDART_FILE, 91}
        };
    }

    @DataProvider(name = "DataForSpeedSum")
    public Object[] createDataForSumOfSpeed() {
        return new Object[][]{
                {EMPTY_FILE, 0.0},
                {ZEROES_FILE, 0.0},
                {STANDART_FILE, 22.274}
        };
    }

    @DataProvider(name = "DataForAddingCars")
    public Object[] createDataForAddingCars() {

        ArrayList<Car> standart = new ArrayList<Car>();
        ArrayList<Car> empty = new ArrayList<Car>();
        standart.add(new Locomotive(4, "LPOX", 3.45, 6.57, 5.67));
        standart.add(new BaggageCar(8, "BRGR", 2000.23, 1500.12));
        standart.add(new Coach(12, "CPR", 3234.55, 49, TypeOfCoach.BUFFET));
        standart.add(new Coach(17, "CPZ", 3534.35, 42, TypeOfCoach.COMPARTMENT));
        standart.add(new Locomotive(21, "LASD", 2012.123, 4.567, 600.123));
        standart.add(new BaggageCar(7, "BRGR", 2320.13, 3900.42));
        return new Object[][]{
                {EMPTY_FILE, empty},
                {STANDART_FILE, standart},
                {"Wrong path", empty}

        };
    }

    @DataProvider(name = "DataForDeletionCars")
    public Object[] createDataForDeletionCars() {

        ArrayList<Car> standart = new ArrayList<Car>();
        ArrayList<Car> editedStandart = new ArrayList<Car>();
        ArrayList<Car> empty = new ArrayList<Car>();

        standart.add(new Locomotive(4, "LPOX", 3.45, 6.57, 5.67));
        standart.add(new BaggageCar(8, "BRGR", 2000.23, 1500.12));
        standart.add(new Coach(12, "CPR", 3234.55, 49, TypeOfCoach.BUFFET));
        standart.add(new Coach(17, "CPZ", 3534.35, 42, TypeOfCoach.COMPARTMENT));
        standart.add(new Locomotive(21, "LASD", 2012.123, 4.567, 600.123));
        standart.add(new BaggageCar(7, "BRGR", 2320.13, 3900.42));

        editedStandart.add(new Locomotive(4, "LPOX", 3.45, 6.57, 5.67));
        editedStandart.add(new BaggageCar(8, "BRGR", 2000.23, 1500.12));
        editedStandart.add(new Coach(12, "CPR", 3234.55, 49, TypeOfCoach.BUFFET));
        editedStandart.add(new Locomotive(21, "LASD", 2012.123, 4.567, 600.123));
        editedStandart.add(new BaggageCar(7, "BRGR", 2320.13, 3900.42));
        return new Object[][]{
                {EMPTY_FILE, 0, empty},
                {STANDART_FILE, 3, editedStandart},
                {STANDART_FILE, 29, standart}

        };
    }

    @DataProvider(name = "DataForNameSearch")
    public Object[] createDataForNameSearch() {

        ArrayList<Car> standart = new ArrayList<Car>();
        ArrayList<Car> editedStandart = new ArrayList<Car>();
        ArrayList<Car> empty = new ArrayList<Car>();

        standart.add(new BaggageCar(8, "BRGR", 2000.23, 1500.12));
        standart.add(new BaggageCar(7, "BRGR", 2320.13, 3900.42));
        return new Object[][]{
                {EMPTY_FILE, "BRGR", empty},
                {STANDART_FILE, "BRGR", standart},
                {STANDART_FILE, "BRGAD2134rw", empty}

        };
    }

    @DataProvider(name = "DataForPassengersSearch")
    public Object[] createDataForPassengersSearch() {

        ArrayList<Car> standart = new ArrayList<Car>();
        ArrayList<Car> empty = new ArrayList<Car>();

        standart.add(new Coach(17, "CPZ", 3534.35, 42, TypeOfCoach.COMPARTMENT));

        return new Object[][]{
                {EMPTY_FILE, 23, 89, empty},
                {STANDART_FILE, 35, 45, standart},
                {STANDART_FILE, -24, -1, empty}

        };
    }

    @DataProvider(name = "DataForNameSort")
    public Object[] createDataForNameSort() {

        ArrayList<Car> standart = new ArrayList<Car>();
        ArrayList<Car> empty = new ArrayList<Car>();

        standart.add(new BaggageCar(8, "BRGR", 2000.23, 1500.12));
        standart.add(new BaggageCar(7, "BRGR", 2320.13, 3900.42));
        standart.add(new Coach(12, "CPR", 3234.55, 49, TypeOfCoach.BUFFET));
        standart.add(new Coach(17, "CPZ", 3534.35, 42, TypeOfCoach.COMPARTMENT));
        standart.add(new Locomotive(4, "LPOX", 3.45, 6.57, 5.67));
        standart.add(new Locomotive(21, "LASD", 2012.123, 4.567, 600.123));

        return new Object[][]{
                {EMPTY_FILE, empty},
                {STANDART_FILE, standart},
        };
    }

    @DataProvider(name = "DataForWeightSort")
    public Object[] createDataForWeightSort() {

        ArrayList<Car> standart = new ArrayList<Car>();
        ArrayList<Car> empty = new ArrayList<Car>();

        standart.add(new Locomotive(4, "LPOX", 3.45, 6.57, 5.67));
        standart.add(new BaggageCar(8, "BRGR", 2000.23, 1500.12));
        standart.add(new Locomotive(21, "LASD", 2012.123, 4.567, 600.123));
        standart.add(new BaggageCar(7, "BRGR", 2320.13, 3900.42));
        standart.add(new Coach(12, "CPR", 3234.55, 49, TypeOfCoach.BUFFET));
        standart.add(new Coach(17, "CPZ", 3534.35, 42, TypeOfCoach.COMPARTMENT));

        return new Object[][]{
                {EMPTY_FILE, empty},
                {STANDART_FILE, standart},
        };
    }

    @Test(dataProvider = "DataForBaggegeSum")
    public void testSumOfBaggage(String path, double expected) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "Method read() got wrong path");
        }


        Assert.assertEquals(carService.calcSumOfBaggage(), expected);
    }

    @Test(dataProvider = "DataForPassengersSum")
    public void testSumOfPassengers(String path, int expected) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "Method read() got wrong path");
        }

        Assert.assertEquals(carService.calcSumOfPassengers(), expected);
    }

    @DataProvider(name = "DataForWeightSearch")
    public Object[] createDataForWeightSearch() {

        ArrayList<Car> standart = new ArrayList<Car>();
        ArrayList<Car> empty = new ArrayList<Car>();

        standart.add(new BaggageCar(8, "BRGR", 2000.23, 1500.12));
        standart.add(new Coach(12, "CPR", 3234.55, 49, TypeOfCoach.BUFFET));
        standart.add(new Locomotive(21, "LASD", 2012.123, 4.567, 600.123));
        standart.add(new BaggageCar(7, "BRGR", 2320.13, 3900.42));
        return new Object[][]{
                {EMPTY_FILE, 2000.0, 3300.0, empty},
                {STANDART_FILE, 2000.0, 3300.0, standart},
                {STANDART_FILE, -2000, -3000, empty}

        };
    }

    @Test(dataProvider = "DataForSpeedSum")
    public void testSumOfSpeed(String path, double expected) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "Method read() got wrong path");
        }

        Assert.assertEquals(carService.calcSumOfSpeed(), expected);

    }

    @Test(dataProvider = "DataForAddingCars")
    public void testAddCars(String path, List<Car> expected) {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();
        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "Method read() got wrong path");
        }

        Assert.assertEquals(repository.getAll(), expected);
    }

    @Test(dataProvider = "DataForDeletionCars")
    public void testDeleteCar(String path, int index, List<Car> expected) {
        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();
        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "Method read() got wrong path");
        }

        try {
            carService.deleteCar(index);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "The train is empty or method got wrong index.");
        }

        Assert.assertEquals(repository.getAll(), expected);
    }

    @Test(dataProvider = "DataForNameSearch")
    public void testSearchByName(String path, String name, List<Car> expected) {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();
        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "Method read() got wrong path");
        }

        Assert.assertEquals(carService.searchByName(name), expected);
    }

    @Test(dataProvider = "DataForPassengersSearch")
    public void testSearchByPassengers(String path, int first, int last, List<Car> expected) {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();
        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "Method read() got wrong path");
        }

        Assert.assertEquals(carService.searchByPassengers(first, last), expected);
    }

    @Test(dataProvider = "DataForWeightSearch")
    public void testSearchByWeight(String path, double first, double last, List<Car> expected) {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();
        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "Method read() got wrong path");
        }

        Assert.assertEquals(carService.searchByWeight(first, last), expected);
    }

    @Test(dataProvider = "DataForNameSort")
    public void testSortByName(String path, List<Car> expected) {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();
        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "Method read() got wrong path");
        }

        Assert.assertEquals(carService.sortByName(), expected);
    }

    @Test(dataProvider = "DataForWeightSort")
    public void testSortByWeight(String path, List<Car> expected) {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();
        try {
            carService.addCars(path);
        } catch (ServiceException e) {
            Assert.assertEquals(e.getMessage(), "Method read() got wrong path");
        }

        Assert.assertEquals(carService.sortByWeight(), expected);
    }
}