import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PrintList printList = new PrintList();
        AddStudent addStudent = new AddStudent();
        Search_by_id searchById = new Search_by_id();

        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please select an option:");
            System.out.println("1. Add student");
            System.out.println("2. Print student list");
            System.out.println("3. Search Student by Matricule");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent.Add();
                    break;
                case 2:
                    printList.print();
                    break;
                case 3:
                    searchById.search();
                    break;
                case 4:
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
