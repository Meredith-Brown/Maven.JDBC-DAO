import daos.ConnectionFactory;
import daos.DAO;
import models.Car;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {
    static DAO dao = new DAO();

    public static void main(String... args) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        while (true) {
            String input = Console.printMainMenu();
            if (input.equals("1")) {
                ArrayList<String> creationInformation = Console.getCreateInformation();
                Car car = new Car(null, creationInformation.get(0), creationInformation.get(1),
                        Integer.parseInt(creationInformation.get(2)), (creationInformation.get(3)),
                        creationInformation.get(4));
                String output = dao.create(car);
                System.out.println(output);
            } else if (input.equals("2")) {
                Console.requestID();
                Car car = dao.findByID(1);
                System.out.println("ID: " + car.getID() + ", make: " + car.getMake() + ", model: " +
                        car.getModel() + ", year: " + car.getYear() + ", color: " +
                        car.getColor() + ", VIN: " + car.getVIN() + "\n");
            } else if (input.equals("3")) {
                List<Car> listOfCars = dao.findAll();
                for (Car car : listOfCars) {
                    System.out.println("ID: " + car.getID() + ", make: " + car.getMake() + ", model: " +
                            car.getModel() + ", year: " + car.getYear() + ", color: " +
                            car.getColor() + ", VIN: " + car.getVIN() + "\n");
                }
            } else if (input.equals("4")) {
                ArrayList<String> updateInformation = Console.getUpdateInformation();
                String output = dao.update(Integer.valueOf(updateInformation.get(0)), updateInformation.get(1),
                        updateInformation.get(2));
                System.out.println(output);
            } else if (input.equals("5")) {
                Integer ID = Console.requestID();
                String output = dao.delete(ID);
                System.out.println(output);
            } else if (input.equals("6")) {
                connection.close();
                break;
            }
        }
    }
}



