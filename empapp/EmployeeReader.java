package empapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EmployeeReader {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\LENOVO\\JAVA PROJECT\\empapp\\src\\empapp\\employee.txt";
        readEmployeeInfo(filePath);
    }

    public static void readEmployeeInfo(String filePath) {
        Path path = Paths.get(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Assuming the format is: ID Name Salary Age
                String[] parts = line.split(" ");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double salary = Double.parseDouble(parts[2]);
                    int age = Integer.parseInt(parts[3]);
                    Employee employee = new Employee(id, name, salary, age);
                    System.out.println(employee);
                }
                else {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

