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
        dao.update(8, "mOdEl", "PopeMobile");
        dao.findAll();
        // dao.delete(7);
        // TODO - TESTS
        // TODO - create console/action selection
        // TODO - DTO???
    }
}



