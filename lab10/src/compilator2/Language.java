package compilator2;
import java.util.Scanner;

public class Language {
    public Compiler createCompiler(){
        //Меню выбора языка программирования
        Scanner in = new Scanner(System.in);
        System.out.println("\n1.Java"
                + System.lineSeparator() + "2.C"
                + System.lineSeparator() + "3.Python");
        System.out.print("Выберите пункт: ");
        int languageName = in.nextInt();
        switch (languageName) {
            case 1:
                //Метод создания объекта Java компилятора
                return createJavaCompiler();
            case 2:
                //Метод создания объекта C компилятора
                return createCCompiler();
            case 3:
                //Метод создания объекта Python компилятора
                return createPythonCompiler();
            default:
                System.out.println("Введен неподдерживаемый компилятором язык программирования!");
                return null;
        }
    }
    public JavaCompiler createJavaCompiler(){
        //Возвращаем созданный объект класса JavaCompiler
        return new JavaCompiler();
    }

    public C_Compiler createCCompiler(){
        //Возвращаем созданный объект класса CCompiler
        return new C_Compiler();
    }

    public PythonCompiler createPythonCompiler(){
        //Возвращаем созданный объект класса PythonCompiler
        return new PythonCompiler();
    }
}
