package Networking.TCPEchoServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CAPECHOClient extends Thread {

    private static final Logger LOG = Logger.getLogger(CAPECHOClient.class.getName());
    Socket server;
    Scanner key;

    public CAPECHOClient(String ip, int port) {
        try {
            server = new Socket(ip, port);
            key = new Scanner(System.in);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void run() {
        DataInputStream istream = null;
        DataOutputStream os = null;
        try {
            istream = new DataInputStream(server.getInputStream());
            os = new DataOutputStream(server.getOutputStream());
            System.out.println(istream.readUTF());
            System.out.println(">");
            String toSend = key.nextLine();
            os.writeUTF(toSend);
            System.out.println(istream.readUTF());
        } catch (IOException e) {
            LOG.log(Level.SEVERE, null, e);
        } finally {
            try {
                istream.close();
                os.close();
            } catch (IOException e) {
                LOG.log(Level.SEVERE, null, e);
            }

        }
    }
}
