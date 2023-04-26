import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Search_by_id {
    public void search() {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDb = connect.getConnection();
        Scanner sc = new Scanner(System.in);

        System.out.println("Search for a student by matricule");
        System.out.println("Enter matricule:");
        String matricule = sc.nextLine();

        String searchQuery = "SELECT * FROM school_management.student WHERE matricule='" + matricule + "';";
        try {
            Statement statement = connectDb.createStatement();
            ResultSet resultSet = statement.executeQuery(searchQuery);

            // print the column headers
            System.out.format("%-20s%-20s%-20s%n", "First Name", "Last Name", "Class");

            if (resultSet.next()) {
                // retrieve the data from the current row
                String studentFirst_Name = resultSet.getString("First_name");
                String studentLast_Name = resultSet.getString("Last_name");
                String studentClass = resultSet.getString("classe_name");

                // print the data in a formatted manner
                System.out.format("%-20s%-20s%-20s%n", studentFirst_Name, studentLast_Name, studentClass);
            } else {
                System.out.println("No student found with matricule " + matricule);
            }

            // close the ResultSet and Statement objects
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

