package empapp;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String name;
        int id;
        double salary;
        int age;
        EmployeeDaoIntrf dao=new EmployeeDaoImpl();
        System.out.println("Welcome to Employee management application");
        EmployeeReader.readEmployeeInfo("C:\\Users\\LENOVO\\JAVA PROJECT\\empapp\\src\\empapp\\employee.txt");
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("""
                    1. Add Employee
                    2. Show All Employee
                    3. Show Employee based on id
                    4. Update the employee
                    5. Delete the employee
                    """);

            System.out.println("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    Employee emp=new Employee();
                    System.out.println("Enter ID : ");
                    id=sc.nextInt();
                    System.out.println("Enter name: ");
                    name=sc.next();
                    System.out.println("Enter Salary ");
                    salary=sc.nextDouble();
                    System.out.println("Enter age");
                    age=sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter id to show the details ");
                    int empid=sc.nextInt();
                    dao.showEmployeeBasedOnID(empid);
                    break;
                case 4:
                    System.out.println("Enter id to update the details");
                    int empid1=sc.nextInt();
                    System.out.println("Enter the new name");
                    name=sc.next();
                    System.out.println("Enter the new age");
                    age=sc.nextInt();
                    System.out.println("Enter the new salary");
                    salary=sc.nextDouble();
                    dao.updateEmployee(empid1,name,age,salary);
                    break;
                case 5:
                    System.out.println("Enter the id to delete");
                    id=sc.nextInt();
                    dao.deleteEmployee(id);
                    break;

                case 6:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !");
                    break;


            }

        }while (true);

    }
}
