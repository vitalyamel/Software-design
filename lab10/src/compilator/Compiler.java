package compilator;

public abstract class Compiler {
    //Абстрактный метод компиляции
    public abstract void Compilation(String file);
    //Абстрактный метод лекцического анализа
    public abstract void Lexer();
    //Абстрактный метод парсинга
    public abstract void Parser();
    //Абстрактный метод оптимизации
    public abstract void Optimizator();
    //Абстрактный метод генерации объектного кода
    public abstract void CodeGenerator();
}
