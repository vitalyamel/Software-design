package compilator2;

public abstract class Compiler {
    //массив лексем
    String[] LEXEMS;
    //массив триад
    String[] TRIADS;
    //массив идентификаторов
    String[] ID;
    //Оптимизация
    String OPTIMIZATION;
    //Объектный код
    String OBJECT_CODE;
    //Исходный код
    String CODE;

    //Абстрактный метод компиляции
    public abstract void Compilation();
    //Абстрактный метод лекцического анализа
    public abstract void Lexer();
    //Абстрактный метод парсинга
    public abstract void Parser();
    //Абстрактный метод оптимизации
    public abstract void Optimizator();
    //Абстрактный метод генерации объектного кода
    public abstract void CodeGenerator();
    //Абстрактный метод для вывода таблицы лексем
    public abstract void LEXEMStable_toString();
    //Абстрактный метод для вывода триад
    public abstract void TRIADS_toString();
    //Абстрактный метод для вывода таблицы идентификаторов
    public abstract void IDtable_toString();
    //Абстрактный метод для вывода результатов оптимизации
    public abstract void OPTIMIZATION_toString();
    //Абстрактный метод для вывода объектного кода
    public abstract void OBJECT_CODE_toString();
    //Абстрактный метод для вывода кода с консоли
    public abstract void InputCode();
}
