package testdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "@Ish1327";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connection Successful!");
            conn.close();
        } catch (SQLException e) {
            System.out.println("❌ Connection Failed!");
            e.printStackTrace();
        }
    }
}

