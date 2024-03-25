package Networking.BasicClientServer;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 1234)){
            OutputStream os = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.println("Hello from the client!");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
