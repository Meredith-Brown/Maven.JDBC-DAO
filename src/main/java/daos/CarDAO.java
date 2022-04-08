package daos;

import models.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDAO<T> {
    public Car findByID(Integer ID) throws SQLException;
    public List<Car> findAll() throws SQLException;
    public String update(Integer ID, String field, T newValue) throws SQLException;
    public String create (Car car) throws SQLException;
    public String delete (Integer ID) throws SQLException;
}


