package daos;

import models.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                System.out.println(car.getMake() + " " + car.getModel());
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
                System.out.println(car.getMake() + " " + car.getModel());
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
    public T create(T dto) {
        return null;
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