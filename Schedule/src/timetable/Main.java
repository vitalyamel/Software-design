package timetable;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Input launch = new Input();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }
}
