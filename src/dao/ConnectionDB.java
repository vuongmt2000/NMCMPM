package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/qlnvh";
            String user = "root";
            String password = "uchihamadara28@";
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("hello world");
            }

        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
