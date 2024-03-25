package Networking;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;

import javax.naming.ldap.Rdn;

public class ReadWebPage {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.google.com", 80);
        OutputStream outStream = socket.getOutputStream();
        InputStream inStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        PrintWriter writer = new PrintWriter(new BufferedOutputStream(outStream));
        writer.print("something here and there");
        writer.flush();

        System.out.println(readFully(reader));
        socket.close();


    }

    private static String readFully(Reader in){
        StringBuilder sb = new StringBuilder();
        int BUFFER_SIZE = 1024;
        char[] buffer = new char[BUFFER_SIZE];
        int charsRead = 0;
        try {
            while((charsRead = in.read(buffer, 0 , BUFFER_SIZE)) != -1){
                sb.append(buffer, 0, charsRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
