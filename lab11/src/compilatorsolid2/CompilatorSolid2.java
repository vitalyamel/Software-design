package compilatorsolid2;

import java.util.Scanner;

public class CompilatorSolid2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Меню выбора:"
                + System.lineSeparator() + "1.Java"
                + System.lineSeparator() + "2.C"
                + System.lineSeparator() + "3.Python");
        System.out.print("Выберите язык: ");
        //создаем компилятор
        CompilerCreator objCompilerCreator = new CompilerCreator();
        Compiler objCompiler = objCompilerCreator.createCompiler(in.nextLine());

        //вводим код
        Code objFile = new Code();
        objFile.CodeEntry(objCompiler);

        //запускаем компиляцию
        CompileStarter objCompileStarter = new CompileStarter();
        objCompileStarter.Compile(objCompiler);

        //выводим промежуточные результаты
        IntermediateResults objIntermediateResults = new IntermediateResults();
        objIntermediateResults.getIntermediateResults(objCompiler);

    }
}
