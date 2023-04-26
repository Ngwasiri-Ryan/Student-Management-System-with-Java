import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrintList {
    public void print() {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDb = connect.getConnection();

        System.out.println("Here is the class list");

        String retrieveFields = "SELECT * FROM school_management.student ORDER BY First_name ASC;";

        try {
            Statement statement = connectDb.createStatement();
            ResultSet resultSet = statement.executeQuery(retrieveFields);

            // print the column headers
            System.out.format("%-20s%-20s%-20s%n", "First Name", "Last Name", "Class");

            while (resultSet.next()) {
                // retrieve the data from the current row
                String studentFirst_Name = resultSet.getString("First_name");
                String studentLast_Name = resultSet.getString("Last_name");
                String studentClass = resultSet.getString("classe_name");

                // print the data in a formatted manner
                System.out.format("%-20s%-20s%-20s%n", studentFirst_Name, studentLast_Name, studentClass);
            }

            // close the ResultSet and Statement objects
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



