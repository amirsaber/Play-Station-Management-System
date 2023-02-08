
package javafxapplication11;
 
import AlertMaker.AlertMaker;
import java.sql.*;

public class SqliteConnection {
 private AlertMaker alert = new AlertMaker();
    public static Connection Connector() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\ProgramData\\Miicrosoft Ps_Help\\Mydatabase\\Clinic_Manager_DB.db");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            AlertMaker.showErrorMessage(e, "Connection Error", "Can't find the database file. All program function will not working probably");
            return null;
          
        }
    }
}
