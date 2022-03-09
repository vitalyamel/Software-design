package passverification;
import java.util.Scanner;

public class Input {
   public Input(){
       inputPass();
   }

   public static void inputPass(){
       Scanner pass = new Scanner(System.in);
       String password = "Pa$$w0rd";
       System.out.print("Enter your password: ");
       String newPassword = pass.nextLine();
       Verification PS= new Verification(newPassword,password);
   }
}
