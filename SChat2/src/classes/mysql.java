package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author shayne
 */
public class mysql {

    public static Statement sql() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schat", "root", "123");
        Statement st = con.createStatement();
        return st;
    }
}
