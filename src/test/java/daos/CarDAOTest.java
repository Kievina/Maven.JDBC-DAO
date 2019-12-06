package daos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarDAOTest {
    private CarDAO carDAO;

    @Before
    public void setUp() throws Exception {
        this.carDAO = new CarDAO();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findByIdTest() {
        String expectedVin = "1GC4CZC80BF120492";
        CarDTO car = carDAO.findById(5);
        String actualVin = car.getVin();
        Assert.assertEquals(expectedVin, actualVin);
    }

    @Test
    public void findAllTest() {
        List<CarDTO> cars = carDAO.findAll();
        Integer expectedSize = cars.size();
        Integer actualSize = carDAO.findAll().size();
        Assert.assertEquals(expectedSize, actualSize);

    }

    @Test
    public void updateTest() {
        String expectedColor = "Black";
        CarDTO car = carDAO.findById(3);
        car.setColor(expectedColor);
        carDAO.update(car);
        String actualColor = carDAO.findById(3).getColor();
        Assert.assertEquals(expectedColor, actualColor);
    }

    @Test
    public void createTest() {
        String expectedMake = "Ford";
        String expectedModel = "Focus";
        int expectedYear = 2012;
        String expectedColor = "Green";
        String expectedVin = "3D7TT2CT1BG120433";
        CarDTO expectedCar = new CarDTO(expectedMake, expectedModel, expectedYear, expectedColor, expectedVin);

        CarDTO actualCar = carDAO.create(expectedCar);
        int expectedId = expectedCar.getId();

        int actualId = actualCar.getId();

        Assert.assertEquals(expectedId, actualId);
    }

    @Test
    public void delete() {
        String expectedMake = "Ford";
        String expectedModel = "Focus";
        int expectedYear = 2012;
        String expectedColor = "Green";
        String expectedVin = "3D7TT2CT1BG120433";

        CarDTO expectedCar = new CarDTO(expectedMake, expectedModel, expectedYear, expectedColor, expectedVin);

        carDAO.delete(expectedCar.getId());
    }
}