package daos;

import java.sql.*;
import java.util.*;

//The CarDAO class implements all the functionality required for fetching, updating, and removing User objects.

public class CarDAO implements Dao<CarDTO> {

    private CarDTO extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(resultSet.getInt("id"));
        carDTO.setMake(resultSet.getString("make"));
        carDTO.setModel(resultSet.getString("model"));
        carDTO.setYear(resultSet.getInt("year"));
        carDTO.setColor(resultSet.getString("color"));
        carDTO.setVin(resultSet.getString("vin"));
        return carDTO;
    }

    public CarDTO findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement query = connection.createStatement();
            ResultSet resultSet = query.executeQuery("SELECT * FROM Cars WHERE id=" + id);
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
            ResultSet resultSet = query.executeQuery("SELECT * FROM Cars");
            List<CarDTO> carDTOS = new ArrayList<CarDTO>();
            while (resultSet.next()) {
                CarDTO carDTO = extractUserFromResultSet(resultSet);
                carDTOS.add(carDTO);
            }
            return carDTOS;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public CarDTO update(CarDTO dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Cars SET make=?, model=?, year=?, color=?, vin=? WHERE id=?");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getVin());
            ps.setInt(6, dto.getId());
            int i = ps.executeUpdate();
            if (i == 1)
                return dto;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public CarDTO create(CarDTO dto) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Cars VALUES (NULL, ?, ?, ?, ?, ?)");
            //"make", "model", "year", "color", "vin";
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setString(5, dto.getVin());
            int i = ps.executeUpdate();
            if (i == 1)
                return dto;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement query = connection.createStatement();
            int i = query.executeUpdate("DELETE FROM Cars WHERE id=" + id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}