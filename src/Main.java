
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== EMPLOYEE INFORMATION SYSTEM =====");
            System.out.println("1. Write Employee Records");
            System.out.println("2. Read Employee Records");
            System.out.println("3. Append Employee Records");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");

            String input = sc.nextLine();

            try {

                int choice = Integer.parseInt(input);

                switch (choice) {

                    case 1:
                        EmployeeInformationSystem.writeEmployee(sc, false);
                        break;

                    case 2:
                        EmployeeInformationSystem.readEmployees();
                        break;

                    case 3:
                        EmployeeInformationSystem.writeEmployee(sc, true);
                        break;

                    case 4:
                        System.out.println("Exiting the application...");
                        sc.close();
                        return;

                    default:
                        System.out.println(
                                "Invalid choice! Please enter 1 to 4."
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");

            }
        }
    }
}

