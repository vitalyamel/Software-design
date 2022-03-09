package compilator;

public class Compilator {
    public static void main(String[] args) {
        //Создаем объект класса Language
        Language objLanguage = new Language();
        /*Создаем обект класса Compiler и инициализируем его
         новым объектом одного из трек языков, поддерживаемых компилятором*/
        Compiler objCompiler = objLanguage.createCompiler();
        //Запускаем процесс копиляции, отправляя ссылку на файл
        objCompiler.Compilation("InputCode.txt");
    }
}
