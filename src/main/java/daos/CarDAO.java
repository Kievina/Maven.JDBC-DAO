package daos;

import models.Car;

import java.sql.*;
import java.util.*;

//The CarDAO class implements all the functionality required for fetching, updating, and removing User objects.

public class CarDAO implements Dao<Car> {
    private List<Car> carList = new ArrayList<Car>();

    private Car extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setMake(resultSet.getString("make"));
        car.setModel(resultSet.getString("model"));
        car.setYear(resultSet.getInt("year"));
        car.setColor(resultSet.getString("color"));
        car.setYear(resultSet.getInt("year"));
        return car;
    }

    public Car findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM carRecords WHERE id=" + id);
            if (resultSet.next()) {
                return extractUserFromResultSet(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM carRecords");
            List cars = new ArrayList();
            while (resultSet.next()) {
                Car car = extractUserFromResultSet(resultSet);
                cars.add(car);
            }
            return cars;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Car update(Car dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE carRecords SET make=?, model=?, year=?, color=?, vin=?");
        ps.setString(1, dto.getMake());
        ps.setString(2, dto.getModel());
        ps.setInt(3, dto.getYear());
        ps.setString(4, dto.getColor());
        ps.setString(5, dto.getVin());
        int i = ps.executeUpdate();
        if(i == 1)
            return dto;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Car create(Car dto) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cars VALUES (NULL, ?, ?, ?, ?, ?)");
            //"make", "model", "year", "color", "vin";
//            ps.setString(1, dto.getMake());
//            ps.setString(2, dto.getModel());
//            ps.setInt(3, dto.getYear());
//            ps.setString(4, dto.getColor());
//            ps.setString(5, dto.getVin());
//            int i = ps.executeUpdate();
//            if (i == 1) {
//                return dto;
//            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement query = connection.createStatement();
            int i = query.executeUpdate("DELETE FROM carRecords WHERE id=" + id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
