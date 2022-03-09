package compilator2;
import java.util.Scanner;

public class Compilator2 {
    public static void main(String[] args) {
        //Создаем объект класса Language
        Language objLanguage = new Language();
        Compiler objCompiler = null;
        //Меню выбора
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("\nМеню выбора:\n"
                    + "1. Выбрать язык\n"
                    + "2. Ввести код\n"
                    + "3. Вывести таблицу лексем\n"
                    + "4. Вывести таблицу идентификаторов\n"
                    + "5. Вывести триады\n"
                    + "6. Вывести результат оптимизации\n"
                    + "7. Вывести объектный код\n"
                    + "8. Выйти из программы");
            System.out.print("Выберите пункт: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                /*Создаем обект класса Compiler и инициализируем его
                    новым объектом одного из трек языков,
                    поддерживаемых компилятором*/
                    objCompiler = objLanguage.createCompiler();
                    break;
                case 2:
                    //запускаем метод для ввода кода
                    objCompiler.InputCode();
                    //запускаем метод для запуска процесса компиляцйии
                    objCompiler.Compilation();
                    break;
                case 3:
                    //запускаем метод длявывода таблицы лексем
                    objCompiler.LEXEMStable_toString();
                    break;
                case 4:
                    //запускаем метод для вывода таблицы идентификаторов
                    objCompiler.IDtable_toString();
                    break;
                case 5:
                    //запускаем метод для вывода триад
                    objCompiler.TRIADS_toString();
                    break;
                case 6:
                    //запускаем метод для вывода результата потимизации
                    objCompiler.OPTIMIZATION_toString();
                    break;
                case 7:
                    //запускаем метод для вывода объектного кода
                    objCompiler.OBJECT_CODE_toString();
                    break;
                case 8:
                    //завершаем работу программы
                    System.out.println("Работа программы завершена!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Такого пункта нет в меню, попробуйте еще раз.");
            }
        }while(true);
    }
}
