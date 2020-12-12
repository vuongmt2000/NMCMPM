package dao;


import dao.impl.DeviceDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import model.Device;


public class ConnectionDB {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/qlnvh";
            String user = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("hello world");
            }
            
           IDeviceDAO deviceDAO = new DeviceDAO();
           List<Device> list = deviceDAO.findAll();
           for(Device de : list){
               System.out.println(de.getName());
               System.out.println(de.getPrice());
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
