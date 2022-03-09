package httpclient;
import java.io.*;
import java.net.*;
import java.util.*;

public class StartClient {
    static String host;
    static int port;
    static Socket socket = null;

    public StartClient(String host, int port) throws IOException{
        try {
            this.host=host;
            this.port=port;
            System.out.println("Connection_____");
            placeFile();
            getAnswer();
        }catch (IOException e){
            System.out.println("Error: "+e);
        }
    }
       public static  void placeFile() throws IOException{
        InputStream in=null;
        OutputStream out=null;
        try{
            socket = new Socket(host, port);
            System.out.println("Connection Successful!");
            Scanner INP=new Scanner(System.in);
            System.out.print("Enter file path: ");
            String way=INP.nextLine();
            File file = new File(way);

            byte[] bytes = new byte[16 * 1024];
            in = new FileInputStream(file);
            out = socket.getOutputStream();

            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }
            out.close();
            in.close();
            System.out.println("File sent to server");
        } catch (IOException e){
            System.out.println("Error: "+e);
        }
       }
       public static void getAnswer() throws IOException{
          try {
              socket=new Socket(host, port);
              System.out.println("The connection was successful!");
              //открывает потоки для чтения ответа от сервера
              BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
              System.out.println("Getting a response from the server...\n");
              //читаем содержимое потоков и инициализируем им строковую переменную
              String answer = br.readLine();
              //ответ выводим, заменяя тройной пробел на перенос строки
              System.out.println(answer.replaceAll("   ", "\n"));
              //закрываем сокет
              socket.close();
              System.out.println("\nDisconnection...");
          } catch (IOException e){
              System.out.println("Error: "+e);
          }
       }
}
