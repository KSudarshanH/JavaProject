package empapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoIntrf {
    Connection con;

    @Override
    public void createEmployee(Employee emp) {
        con = DBConnection.createDBConnection();
        String query="insert into employee(ID ,NAME ,SALARY ,AGE) values(?,?,?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Inserted Successfully !!!");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showAllEmployee() {
        con=DBConnection.createDBConnection();
        String query="select * from employee";
        System.out.println("Employee Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","age");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con=DBConnection.createDBConnection();
        try{
        PreparedStatement preparedStatement5 = con.prepareStatement("SELECT * FROM employee WHERE ID=?");
        preparedStatement5.setInt(1, id);
        ResultSet result= preparedStatement5.executeQuery();
            if(result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt("id"),
                        result.getString("name"),
                        result.getDouble("salary"),
                        result.getInt("age"));

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    @Override
    public void updateEmployee(int id, String name,int age,double salary) {
        con=DBConnection.createDBConnection();
        try{
            PreparedStatement pstm=con.prepareStatement("update employee "+"SET NAME=?,AGE=?,SALARY=?"+"WHERE ID=?");
            pstm.setString(1,name);
            pstm.setInt(2,age);
            pstm.setDouble(3,salary);
            pstm.setInt(4,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        con=DBConnection.createDBConnection();
        String query="delete from employee where id=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Deleted Successfully!!! "+id);

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
