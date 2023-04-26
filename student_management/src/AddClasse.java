import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class AddClasse {
    public void Add() {
        DatabaseConnection connect = new DatabaseConnection();
        Connection connectDb = connect.getConnection();
        Scanner sc = new Scanner(System.in);


        System.out.println("Add a Class");
        System.out.println("Enter the name of the class");
        String Name = sc.nextLine();

        String InsertFields = "INSERT INTO school_management.classe(name) VALUES ('";
        String InsertValues = Name + "')";
        String InsertToAdd = InsertFields + InsertValues;

        try {
            Statement statement = connectDb.createStatement();
            statement.executeUpdate(InsertToAdd);
            System.out.println("Class Added Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

