package httpclient;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
    static String host;
    public static void main(String[] args) {
        try {
            getHost();
            StartClient  launch = new StartClient (host, 8008);
        }catch (IOException e){
            System.out.println("Error: "+e);
        }
    }
    static private void getHost() throws IOException{
        InetAddress currentIP = null;
        try {
            currentIP = InetAddress.getLocalHost();
            host = currentIP.getHostAddress();
        } catch (UnknownHostException e) {
            System.err.println("The address is not available!" + e);
            host = "localhost";
        }
    }
}
