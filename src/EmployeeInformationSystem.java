
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeInformationSystem {

    static final String FILE_NAME = "Employee.txt";

    // Method to write and append employee records
    public static void writeEmployee(Scanner sc, boolean append) {

        try (FileOutputStream fos =
                     new FileOutputStream(FILE_NAME, append)) {

            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Designation: ");
            String designation = sc.nextLine();

            System.out.print("Enter Salary: ");
            String salary = sc.nextLine();

            String record = id + "," + name + ","
                    + designation + "," + salary
                    + System.lineSeparator();

            // Convert employee details into bytes
            byte[] data = record.getBytes("UTF-8");

            // Write bytes into the file
            fos.write(data);

            System.out.println(
                    "\nEmployee record successfully written to the file."
            );

        } catch (IOException e) {

            System.out.println("Error writing file: " + e.getMessage());

        }
    }

    // Method to read and display employee records
    public static void readEmployees() {

        try (FileInputStream fis =
                     new FileInputStream(FILE_NAME)) {

            StringBuilder content = new StringBuilder();

            int data;

            // Read file byte by byte
            while ((data = fis.read()) != -1) {

                content.append((char) data);

            }

            if (content.toString().trim().isEmpty()) {

                System.out.println("\nNo employee records found.");
                return;

            }

            System.out.println("\n========== EMPLOYEE RECORDS ==========");

            System.out.println(
                    "+------------+----------------------+----------------------+------------+"
            );

            System.out.printf(
                    "| %-10s | %-20s | %-20s | %-10s |%n",
                    "ID", "NAME", "DESIGNATION", "SALARY"
            );

            System.out.println(
                    "+------------+----------------------+----------------------+------------+"
            );

            // Separate employee records
            String[] records = content.toString().split("\\R");

            for (String record : records) {

                if (record.trim().isEmpty()) {
                    continue;
                }

                String[] details = record.split(",", -1);

                if (details.length == 4) {

                    System.out.printf(
                            "| %-10s | %-20s | %-20s | %-10s |%n",
                            details[0],
                            details[1],
                            details[2],
                            details[3]
                    );

                } else {

                    System.out.println(
                            "Invalid employee record: " + record
                    );

                }
            }

            System.out.println(
                    "+------------+----------------------+----------------------+------------+"
            );

        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());

        }
    }
}
