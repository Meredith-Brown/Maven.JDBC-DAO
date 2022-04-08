import daos.ConnectionFactory;
import daos.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    static DAO dao = new DAO();

    public static void main(String... args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        dao.findByID(1);
        dao.findAll();


    }
}

// Create an App runner class to run each CRUD operation against your DAO
//
//findById()
//findAll()
//update()
//create()
//delete()



