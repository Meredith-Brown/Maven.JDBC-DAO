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
                System.out.println("ID " + ID + ": " + car.getMake() + " " + car.getModel());
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
            for (Car car : listOfCars) {
                System.out.println("ID " + car.getID() + ": " + car.getMake() + " " + car.getModel());
            }
            return listOfCars;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T update(T dto) {
        return null;
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
                return ("ID " + car.getID() + ": " + car.getMake() + " " + car.getModel() + " successfully " +
                        "added to database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "ADD CAR TO DATABASE UNSUCCESSFUL";
    }

    @Override
    public void delete(Integer ID) {

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