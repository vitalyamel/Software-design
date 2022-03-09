package compilatorsolid;

public class Language {

    public Compiler createCompiler(String LauguageName) {
        //выбор языка компилятора
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

class File {

    public void FileEntry(String file, Compiler objCompiler) {
        objCompiler.setFile(file);
    }
}

class CompileStarter {

   //метод запуска компилятора
    public void Compile(Compiler objCompiler) {
        objCompiler.StartCompilation();
    }
}
