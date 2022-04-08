import daos.ConnectionFactory;
import daos.DAO;
import models.Car;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    static DAO dao = new DAO();

    public static void main(String... args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        dao.findByID(1);
        Car car = new Car(null, "Jeep", "Grand Cherokee", 2013, "gray",
                "MAB100292");
        dao.create(car);
        dao.findAll();
        // TODO - TESTS


    }
}

//update()
//create()
//delete()



