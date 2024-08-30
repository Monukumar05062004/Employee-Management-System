package Employee.Management.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;
    Conn(){
        //Establish a connection
        try{
            connection= DriverManager.getConnection("jdbc:mysql:///employeemanagement","root","Monukumar05062004");
            statement=connection.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }

           }
}
