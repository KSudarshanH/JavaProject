package empapp;

public interface EmployeeDaoIntrf {
    //create employee
    public void createEmployee(Employee emp);
    //show all employee
    public void showAllEmployee();
    //show employee based on id
    public void showEmployeeBasedOnID(int id);
    //update employee
    void updateEmployee(int id, String name, int age,double salary);

    //delete employee
    public void deleteEmployee(int id);
}
