import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    public static String printMainMenu() {
        System.out.println("Please select from one of the following options:" + "\n"
                + "Enter '1' to add a car to the database." + "\n"
                + "Enter '2' to find a car by ID." + "\n"
                + "Enter '3' to see all cars in the database." + "\n"
                + "Enter '4' to update a car in the database." + "\n"
                + "Enter '5' to delete a car from the database." + "\n"
                + "Enter '6' to exit." + "\n");
        String input = getStringInput();
        return input;
    }

    public static Integer requestID() {
        System.out.println("Please enter the car's ID: ");
        Integer input = getIntegerInput();
        return input;
    }

    public static ArrayList<String> getUpdateInformation() {
        ArrayList<String> updateInformation = new ArrayList<String>();
        System.out.println("Please enter the car's ID: ");
        String input1 = getStringInput();
        updateInformation.add(input1);
        System.out.println("Please enter the field to update: ");
        String input2 = getStringInput();
        updateInformation.add(input2);
        System.out.println("Please enter the new value: ");
        String input3 = getStringInput();
        updateInformation.add(input3);
        return updateInformation;
    }

    public static ArrayList<String> getCreateInformation() {
        ArrayList<String> creationInformation = new ArrayList<String>();
        String[] fields = {"make", "model", "year", "color", "VIN"};
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Please enter the " + fields[i] + ":");
            String input = getStringInput();
            creationInformation.add(input);
        }
        return creationInformation;
    }

    public static String getStringInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static Integer getIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        Integer userInput = scanner.nextInt();
        return userInput;
    }
}
