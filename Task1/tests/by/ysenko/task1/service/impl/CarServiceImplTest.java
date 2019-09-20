package by.ysenko.task1.service.impl;


import by.ysenko.task1.bean.BaggageCar;
import by.ysenko.task1.bean.Coach;
import by.ysenko.task1.bean.Locomotive;
import by.ysenko.task1.bean.TypeOfCoach;
import by.ysenko.task1.repository.CarRepositoryImpl;
import by.ysenko.task1.service.CarService;
import by.ysenko.task1.service.exception.ServiceException;
import by.ysenko.task1.service.factory.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
                {STANDART_FILE, 5400, 54},
                {ZEROES_FILE, 0.0},
                {EMPTY_FILE, 0.0}
        };
    }


    @Test(expectedExceptions = {ServiceException.class},
            dataProvider = "DataForBaggegeSum")
    public void testGetSumOfBaggageNormal(String path, double expected) throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();
        carService.addCars(path);

        Assert.assertEquals(carService.calcSumOfBaggage(), expected);

    }

    @Test
    public void testGetSumOfPassengersNormal() {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        repository.addCar(new Coach(12, "PS",
                4, 12, TypeOfCoach.COMPARTMENT));
        repository.addCar(new BaggageCar(12, "PS", 4, 82.3));
        repository.addCar(new Coach(34, "MOS",
                2.56, 24, TypeOfCoach.BUFFET));

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        int expected = 36;

        Assert.assertEquals(carService.calcSumOfPassengers(), expected);
    }

    @Test
    public void testGetSumOfPassengersEmptyTrain() {


        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        int expected = 0;

        Assert.assertEquals(carService.calcSumOfPassengers(), expected);
    }

    @Test
    public void testGetSumOfSpeedNormal() {

        CarRepositoryImpl repository = CarRepositoryImpl.getInstance();

        repository.addCar(new Locomotive(12, "PS", 4, 12.3, 123));
        repository.addCar(new BaggageCar(12, "PS", 4, 82.3));
        repository.addCar(new Locomotive(12, "PS", 4, 23.4, 457));

        double expected = 0.357;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        Assert.assertEquals(carService.calcSumOfSpeed(), expected);
    }

    @Test
    public void testGetSumOfSpeedEptyTrain() {

        double expected = 0.0;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CarService carService = serviceFactory.getCarService();

        Assert.assertEquals(carService.calcSumOfSpeed(), expected);
    }

    @Test
    public void testAddCars() {
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