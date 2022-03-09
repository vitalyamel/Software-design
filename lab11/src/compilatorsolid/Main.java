package compilatorsolid;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        System.out.println("Меню выбора:"
                + System.lineSeparator() + "1.Java"
                + System.lineSeparator() + "2.C"
                + System.lineSeparator() + "3.Python");
        System.out.print("Выберите язык: ");
        //создаем компилятор
        Language objCompilerCreator = new Language();
        Compiler objCompiler = objCompilerCreator.createCompiler(in.nextLine());

        //задаем путь к файлу
        File objFile = new File();
        objFile.FileEntry("InputCode.txt", objCompiler);

        //запускаем компиляцию
        CompileStarter objCompileStarter = new CompileStarter();
        objCompileStarter.Compile(objCompiler);
    }
}
