package studentapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/studentdb";
                String user = "root";   // Replace with your MySQL user
                String password = "@Ish1327";   // Replace with your MySQL password

                conn = DriverManager.getConnection(url, user, password);
                System.out.println("✅ Connected to Database");
            } catch (SQLException e) {
                System.out.println("❌ Database Connection Failed");
                e.printStackTrace();
            }
        }
        return conn;
    }

    // ✅ Test Main Method
    public static void main(String[] args) {
        getConnection();
    }
}
