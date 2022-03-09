package httpserver;

import java.io.*;
import java.net.*;
import java.util.*;

public class StartServer {
    static int port;
    static Socket socket = null;
    static ServerSocket serverSocket=null;

    public StartServer(int port) throws IOException{
        try {
            this.port=port;
            serverSocket=new ServerSocket(port);
            System.out.println("Server started successfully!");
        } catch (IOException e){
            System.out.println("Error"+ e);
        }
        getFile(); //метод получение файла от клиента
        sendingReply();
    }
    private void getFile() throws IOException{
        InputStream in=null;
        OutputStream out=null;
        try {
            socket=serverSocket.accept();
            System.out.println("Client connected successfully!");
            in=socket.getInputStream();
            out=new FileOutputStream("ClientData.txt");

            byte[] bytes = new byte[16 * 1024];
            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }
            out.close();
            in.close();
            System.out.println("Received");
        } catch (IOException e){
            System.out.println("Error: "+e);
        }
    }
    private void sendingReply() throws IOException{
        try {
            //генератор случайных чисел
            Random random = new Random();
            //ждем повторного подключения клиента
            socket = serverSocket.accept();
            System.out.println("Client connected!");
            //создаем объект типа File и читаем его содержимое
            File file = new File("ClientData.txt");
            System.out.println("Sending a response to the client");
            PrintStream ps = new PrintStream(socket.getOutputStream());
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            /*Содержимое файла построчно(одна строка - один рубаи)
                  отправляем в строковый лист */
            List<String> list = new ArrayList<>();
            while (bf.ready()) {
                list.add(bf.readLine());
            }
            //случайным образом выбираем значение листа
            String m = list.get(random.nextInt(20));
            //отправляем его клиенту
            ps.print(m);
            ps.flush();
            System.out.println("Response received!");
            //закрываем сокет
            socket.close();
            System.out.println("Client disconnected!");
            //отключаем сервер
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
