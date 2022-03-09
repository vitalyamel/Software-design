package compilator;

public class PythonCompiler extends Compiler {
    //Реализуем все абстрактные методы класса Compiler
    @Override
    public void Compilation(String file) {
        Lexer();
        Parser();
        CodeGenerator();
    }

    @Override
    public void Lexer() {
        System.out.println("Лексический анализ....");
    }

    @Override
    public void Parser() {
        System.out.println("Парсинг....");
    }

    @Override
    public void Optimizator() {
        System.out.println("Оптимизация....");
    }

    @Override
    public void CodeGenerator() {
        System.out.println("Генерация объектного кода....");
    }
}
