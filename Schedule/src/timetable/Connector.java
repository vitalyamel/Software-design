package timetable;
import java.sql.*;

public class Connector {
    public static Statement connection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        String USER = "root";
        String PASSWORD = "79kd5g82zx3";
        String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/schedule?characterEncoding=utf8";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            System.out.println("Executing statement...");
            statement = (Statement) connection.createStatement();
            System.out.println("The connection was made successfully!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}

