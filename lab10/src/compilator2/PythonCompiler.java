package compilator2;

public class PythonCompiler extends Compiler {
    @Override
    public void Compilation() {
        Lexer();
        Parser();
        CodeGenerator();
    }

    @Override
    public void Lexer() {
        System.out.println("\nЛексический анализ....");
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

    @Override
    public void OBJECT_CODE_toString() {
        System.out.println("\n* Объектный код *");
    }

    @Override
    public void OPTIMIZATION_toString() {
        System.out.println("\n* Результат оптимизации *");
    }

    @Override
    public void IDtable_toString() {
        System.out.println("\n* Таблица идентификаторов *");
    }

    @Override
    public void TRIADS_toString() {
        System.out.println("\n* Таблица триад *");
    }

    @Override
    public void LEXEMStable_toString() {
        System.out.println("\n* Таблица лексем *");
    }

    @Override
    public void InputCode() {
        System.out.println("\nВвод кода.....");
    }
}
