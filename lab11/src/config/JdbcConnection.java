package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcConnection {
    public static Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/hangkhong?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "tamdev");

            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
