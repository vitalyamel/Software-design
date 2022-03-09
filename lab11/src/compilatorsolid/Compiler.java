package compilatorsolid;

public abstract class Compiler {
    //поле для хранения пути к файлу
    private String file = null;

    public void setFile(String file) {
        this.file = file;
    }
    /**
     * Метод для запуска компиляции.
     */
    public void StartCompilation(){
        Lexer();
        Parser();
        Optimizator();
        CodeGenerator();
        getObjectCode();
    };

    //Абстрактный метод лекцического анализа
    public abstract void Lexer();
    //Абстрактный метод парсинга
    public abstract void Parser();
    //Абстрактный метод оптимизации
    public abstract void Optimizator();
    //Абстрактный метод генерации объектного кода
    public abstract void CodeGenerator();
    //Абстрактный метод для получения объектного кода
    public abstract void getObjectCode();

}
