
package stock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Asirpa";
    private static final String USER = "root";
    private static final String PASS = "Asirpa12";
    
   public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
    
    public static void main(String[] args) {
        try {
             Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Connection successful!");
        } catch (SQLException ex) {
            System.out.println("❌ Connection failed!");
        }
    }
    
}
