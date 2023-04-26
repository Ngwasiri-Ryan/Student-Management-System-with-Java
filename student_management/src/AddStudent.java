import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AddStudent {
    public void Add() {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDb = connect.getConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("Add a student!");
        System.out.println("Enter Student's First Name");
        String firstName = sc.nextLine();
        System.out.println("Enter Student's Last Name");
        String lastName = sc.nextLine();
        System.out.println("Enter Student's Matricule");
        String matricule = sc.nextLine();

        // Prompt the teacher to choose an existing class or add a new one
        String className = "";
        boolean classExists = false;
        do {
            System.out.println("Enter the name of the class to add the student to:");
            className = sc.nextLine();

            // Check if the class already exists in the database
            String checkClassQuery = "SELECT * FROM school_management.classe WHERE name='" + className + "';";
            try {
                Statement statement = connectDb.createStatement();
                ResultSet resultSet = statement.executeQuery(checkClassQuery);
                if (resultSet.next()) {
                    classExists = true;
                } else {
                    // Prompt the teacher to add the class if it doesn't exist
                    System.out.println("The class '" + className + "' does not exist in the database.");
                    System.out.println("Would you like to add it? (y/n)");
                    String choice = sc.nextLine();
                    if (choice.equalsIgnoreCase("y")) {
                        // Add the new class to the database
                        String addClassQuery = "INSERT INTO school_management.classe (name) VALUES ('" + className + "');";
                        statement.executeUpdate(addClassQuery);
                        classExists = true;
                    } else if (choice.equalsIgnoreCase("n")) {
                        // Prompt the teacher to provide a valid class name before continuing
                        System.out.println("Please provide a valid class name before continuing.");
                    }
                }
                resultSet.close();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (!classExists);

        // Add the student to the chosen class
        String addStudentQuery = "INSERT INTO school_management.student (first_name, last_name, matricule, classe_name) " +
                "VALUES ('" + firstName + "', '" + lastName + "', '" + matricule + "', '" + className + "');";
        try {
            Statement statement = connectDb.createStatement();
            statement.executeUpdate(addStudentQuery);
            System.out.println("The student was added successfully");
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



