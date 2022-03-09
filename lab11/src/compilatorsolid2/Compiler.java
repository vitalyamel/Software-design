package compilatorsolid2;

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

    /**
     * Метод для инициализации исходного кода.
     * @param InputCode
     */
    public void setCode(String InputCode) {
        this.CODE = InputCode;
    }

    /**
     * Метод для запуска компиляции.
     */
    public void StartCompilation() {
        Lexer();
        Parser();
        Optimizator();
        CodeGenerator();
    }

    /**
     * Метод для вывода промежуточных результатов.
     */
    public void IntermediateResults_toString() {
        LEXEMStable_toString();
        TRIADS_toString();
        IDtable_toString();
        OPTIMIZATION_toString();
        OBJECT_CODE_toString();
    }

    //Абстрактный метод лексического анализа
    public abstract void Lexer();
    //Абстрактный метод парсинга
    public abstract void Parser();
    //Абстрактный метод оптимизации
    public abstract void Optimizator();
    //Абстрактный метод генерации объектного кода
    public abstract void CodeGenerator();

    //метод для вывода таблицы лексем
    public void LEXEMStable_toString(){
        System.out.println("\n* Таблица лексем *");
    }
    //метод для вывода триад
    public void TRIADS_toString(){
        System.out.println("\n* Таблица триад *");
    }
    //метод для вывода таблицы идентификаторов
    public void IDtable_toString(){
        System.out.println("\n* Таблица идентификаторов *");
    }
    //метод для вывода результатов оптимизации
    public void OPTIMIZATION_toString(){
        System.out.println("\n* Результат оптимизации *");
    }
    //метод для вывода объектного кода
    public void OBJECT_CODE_toString(){
        System.out.println("\n* Объектный код *");
    }
}
