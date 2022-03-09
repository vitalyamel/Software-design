package timetable;
import java.sql.*;
import java.util.*;

public class ExecutingRequests {
    static Statement statement;

    public ExecutingRequests() throws ClassNotFoundException, SQLException {
        try {
            //Связываемся с БД
            Connector connector = new Connector();
            statement = connector.connection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //Вывести дни недели, в которых проводится заданное количество занятий.
    public void DayOfWeek (int classes) throws SQLException {
        try {
            //SQL запрос для считывания таблицы с расписанием
            String sqlRequestTimetable = "SELECT * FROM timetable";
            ResultSet RS = this.statement.executeQuery(sqlRequestTimetable);

            HashMap<String,Integer> mass = new HashMap<>();
            mass.put("Monday",0);
            mass.put("Tuesday",0);
            mass.put("Wednesday",0);
            mass.put("Thursday",0);
            mass.put("Friday",0);

            while (RS.next()) {
                String str = RS.getString("Day_week");
                mass.put(str, mass.get(str) + 1);
            }

            for (String s: mass.keySet()){
                if (mass.get(s) == classes)
                    System.out.println(s);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //вывести дни недели, в которые занято заданное кол-во аудиторий
    public void NumbersClassroom (int classroom) throws SQLException{
        try {
            //SQL запрос для считывания таблицы с расписанием
            String sqlRequestTimetable = "SELECT * FROM timetable";
            ResultSet RS = this.statement.executeQuery(sqlRequestTimetable);

            HashMap<String,Integer> mass = new HashMap<>();
            mass.put("Monday",0);
            mass.put("Tuesday",0);
            mass.put("Wednesday",0);
            mass.put("Thursday",0);
            mass.put("Friday",0);

            while (RS.next()) {
                String str = RS.getString("Day_week");
                mass.put(str, mass.get(str) + 1);
            }
            for (String s: mass.keySet()){
                if (mass.get(s) == classroom)
                    System.out.println(s);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}