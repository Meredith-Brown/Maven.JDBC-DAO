package daos;

import models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO<T> implements CarDAO<T>{
    @Override
    public Car findByID(Integer ID) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car WHERE ID=" + ID); // or id?
            if (rs.next()) {
                Car car = extractCarFromResultSet(rs);
                return car;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Car> findAll() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");
            List<Car> listOfCars = new ArrayList<Car>();
            while (rs.next()) {
                Car car = extractCarFromResultSet(rs);
                listOfCars.add(car);
            }
            return listOfCars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String update(Integer ID, String field, T newValue) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        if (field.equalsIgnoreCase("make")) {
            field.toLowerCase();
        } else if (field.equalsIgnoreCase("model")) {
            field.toLowerCase();
        } else if (field.equalsIgnoreCase("year")) {
            field.toLowerCase();
        } else if (field.equalsIgnoreCase("color")) {
            field.toLowerCase();
        } else if (field.equalsIgnoreCase("VIN")) {
            field.toUpperCase();
        }
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET " + field + "=? " +
                    "WHERE ID=" + ID);
            if (newValue instanceof String) {
                ps.setString(1, (String) newValue);
            } else if (newValue instanceof Integer) {
                ps.setInt(1, (Integer) newValue);
            }
            int i = ps.executeUpdate();
            if (i == 1) {
                return ("UPDATE SUCCESSFUL");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "UPDATE UNSUCCESSFUL";
    }

    @Override
    public String create(Car car) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car VALUES (NULL, ?, ?, ?, " +
                    "?, ?)");
            ps.setString(1, car.getMake());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getYear());
            ps.setString(4, car.getColor());
            ps.setString(5, car.getVIN());
            int i = ps.executeUpdate();
            if (i == 1) {
                return (car.getMake() + " " + car.getModel() + " successfully added to database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "ADD CAR TO DATABASE UNSUCCESSFUL";
    }

    @Override
    public String delete(Integer ID) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM car WHERE ID=" + ID);
            if (i == 1) {
                return "DELETE SUCCESSFUL";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "DELETE FROM DATABASE UNSUCCESSFUL";
    }

    public Car extractCarFromResultSet(ResultSet rs) throws SQLException {
        Car car = new Car();
        car.setID(rs.getInt("ID"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setYear(rs.getInt("year"));
        car.setColor(rs.getString("color"));
        car.setVIN(rs.getString("VIN"));
        return car;
    }
}