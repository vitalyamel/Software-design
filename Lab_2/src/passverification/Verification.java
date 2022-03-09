package passverification;

public class Verification {
    static String newPassword;
    static String password;

    public Verification(String newPassword,String password){
        this.newPassword = newPassword;
        this.password = password;
        Verification();
    }
    /**
     * Метод сравнения пароля с образцом.
     */
    public static void Verification() {
        //Проверка пароля с образцом
        if (password.equals(newPassword)) {
            System.out.println("\nThe password is correct.");
        } else {
            System.out.println("\nThe password is incorrect!");
        }
    }
}
