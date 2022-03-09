package timetable;
import java.sql.SQLException;
import java.util.Scanner;
public class Input {
    static ExecutingRequests request;
    static String Day;

    public Input() throws ClassNotFoundException, SQLException {
        try {
            request = new ExecutingRequests();
            MainMenu();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void MainMenu() throws SQLException {
        try{
            Scanner in = new Scanner(System.in);
            do {
                System.out.println("\nМеню выбора:"
                        + "\n1.Вывести дни недели, в которых проводится заданное количество занятий.\n"
                        + "\n2.Вывести дни недели, в которых занято заданное количество аудиторий.\n"
                        + "\n4.Выйти из приложения.\n");
                System.out.print("Выберите пункт: ");
                int Choice = in.nextInt();
                switch (Choice) {
                    case 1:
                        Integer classes=NumbersClasses();
                        System.out.println("\nРезультаты выполнения запроса:");
                        request.DayOfWeek(classes);
                        break;
                    case 2:
                        Integer classroom=NumbersClassroom();
                        System.out.println("\nРезультаты выполнения запроса:");
                        request.NumbersClassroom(classroom);
                        break;

                    default:
                        System.out.println("Такого пункта меню не существует!\n");
                }
            } while (true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Integer NumbersClasses(){
        Scanner in =new Scanner (System.in);
        System.out.println("Укажите количество занятий: ");
        Integer classes = in.nextInt();
        return classes;
    }
    public static Integer NumbersClassroom(){
        Scanner in =new Scanner(System.in);
        System.out.print("Укажите Количество кабинетов: ");
        Integer classroom=in.nextInt();
        return classroom;
    }
}

