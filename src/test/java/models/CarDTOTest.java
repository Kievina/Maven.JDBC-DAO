package models;

import daos.CarDTO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarDTOTest {
private CarDTO carDTO;
private CarDTO testCar;

    @Before
    public void setUp() throws Exception {
        int expectedId = 1;
        String expectedMake = "Ford";
        String expectedModel = "Focus";
        int expectedYear = 2012;
        String expectedColor = "Green";
        String expectedVin = "3D7TT2CT1BG120433";
        this.carDTO = new CarDTO(expectedId, expectedMake, expectedModel, expectedYear, expectedColor, expectedVin);

        testCar = new CarDTO();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void carDTOConstructorTest() {
        int expectedId = 1;
        String expectedMake = "Ford";
        String expectedModel = "Focus";
        int expectedYear = 2012;
        String expectedColor = "Green";
        String expectedVin = "3D7TT2CT1BG120433";
        CarDTO newCar = new CarDTO(expectedId, expectedMake, expectedModel, expectedYear, expectedColor, expectedVin);


        Assert.assertEquals(expectedId, newCar.getId());
        Assert.assertEquals(expectedMake, newCar.getMake());
        Assert.assertEquals(expectedModel, newCar.getModel());
        Assert.assertEquals(expectedYear, newCar.getYear());
        Assert.assertEquals(expectedColor, newCar.getColor());
        Assert.assertEquals(expectedVin, newCar.getVin());
    }

    @Test
    public void getIdTest() {
        int expectedId = 1;
        int actualId = carDTO.getId();
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void setId() {
        int expectedId = 2;
        testCar.setId(expectedId);
        int actualId = testCar.getId();
        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void getMake() {
        String expected = "Ford";
        String actual = carDTO.getMake();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setMake() {
        String expected = "Chevy";
        testCar.setMake(expected);
        String actual = testCar.getMake();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getModel() {
        String expected = "Focus";
        String actual = carDTO.getModel();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setModel() {
        String expected = "Impala";
        testCar.setModel(expected);
        String actual = testCar.getModel();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getYear() {
        int expected = 2012;
        int actual = carDTO.getYear();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setYear() {
        int expected = 2014;
        testCar.setYear(expected);
        int actual = testCar.getYear();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getColor() {
        String expected = "Green";
        String actual = carDTO.getColor();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setColor() {
        String expected = "Blue";
        testCar.setColor(expected);
        String actual = testCar.getColor();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getVin() {
        String expected = "3D7TT2CT1BG120433";
        String actual = carDTO.getVin();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setVin() {
        String expected = "3F7GG2CT1BG120499";
        testCar.setVin(expected);
        String actual = testCar.getVin();
        Assert.assertEquals(expected, actual);
    }
}