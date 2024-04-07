package Networking.TCPEchoServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.chrono.IsoEra;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CAPECHOServer extends Thread {
    private static final Logger LOG = Logger.getLogger(CAPECHOServer.class.getName());
    ServerSocket serverSocket;
    
    public CAPECHOServer(int port, int timeout){
        try{
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(timeout);
        } catch(IOException e){
            LOG.log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                try {
                    LOG.log(Level.INFO, "Listening for clients at {0} on {1} ", new Object[]{serverSocket.getLocalPort(), InetAddress.getLocalHost().getHostAddress()});
                    Socket client = serverSocket.accept();
                    DataInputStream is = new DataInputStream(client.getInputStream());
                    DataOutputStream os = new DataOutputStream(client.getOutputStream());
                    os.writeUTF("welcome");
                    String inString = is.readUTF();
                    String outString = inString.toUpperCase();
                    os.writeUTF(outString);
                    is.close();
                    os.close();
                    client.close();
                } catch (IOException e) {
                    LOG.log(Level.SEVERE, null, e);
                }
            }
            serverSocket.close();
        } catch (IOException e) {
            LOG.log(Level.SEVERE, null, e);
        }
    }
    
}
