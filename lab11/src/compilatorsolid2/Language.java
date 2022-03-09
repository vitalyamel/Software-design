package compilatorsolid2;
import java.util.Scanner;

class CompilerCreator {

    /**
     * Метод, который создает компилятор.
     *
     * @param LauguageName
     */
    public Compiler createCompiler(String LauguageName) {

        switch (LauguageName) {
            case "Java":
                return new JavaCompiler();
            case "C":
                return new CCompiler();
            case "Python":
                return new PythonCompiler();
        }
        return null;
    }
}
class CompileStarter {

    /**
     * Метод, который запускает компилятор.
     *
     * @param objCompiler
     */
    public void Compile(Compiler objCompiler) {
        objCompiler.StartCompilation();
    }
}

class Code {

    /**
     * Метод для ввода исходного кода.
     * @param objCompiler
     */
    public void CodeEntry(Compiler objCompiler) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите исходный код: ");
        objCompiler.setCode(in.nextLine());
    }
}

class IntermediateResults {

    /**
     * Метод для вывода промежуточных результатов.
     * @param objCompiler
     */
    public void getIntermediateResults(Compiler objCompiler) {
        objCompiler.IntermediateResults_toString();
    }
}