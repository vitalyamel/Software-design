package httpserver;

import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {
        try {
            StartServer launch=new StartServer(8008);
        } catch (IOException e){
            System.out.println("Error"+e);
        }

    }

}