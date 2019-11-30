package daos;

import models.Car;

import java.util.ArrayList;
import java.util.List;

//The CarDao class implements all the functionality required for fetching, updating, and removing User objects.

public class CarDao implements Dao<Car> {
    private List<Car> carList = new ArrayList<Car>();

    public CarDao() {
        carList.add(new Car());
    }

    public Car findById(int id) {
        return null;
    }

    public List findAll() {
        return carList;
    }

    public Car update(Car dto) {
        return null;
    }

    public Car create(Car dto) {
        return null;
    }

    public void delete(int id) {
        carList.remove(findById(id));
    }
}
