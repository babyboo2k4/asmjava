package assm2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testdatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/assm2";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (connection != null) {
                System.out.println("Kết nối thành công!");
            } else {
                System.out.println("Kết nối thất bại!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
