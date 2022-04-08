package daos;

import models.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDAO<T> {
    public Car findByID(Integer ID) throws SQLException;
    public List<Car> findAll() throws SQLException;
    public T update(T dto);
    public String create (Car car) throws SQLException;
    public void delete (Integer ID);
}


