package Networking.Multicasting;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Server {
    private DatagramSocket serverSocket;
    private String ip;
    private int port;
    public Server(String ip, int port) throws SocketException {
        this.ip = ip;
        this.port = port;
        serverSocket = new DatagramSocket();
    }

    public void send() throws UnknownHostException {
        byte[] message = ("something").getBytes();
        DatagramPacket packet = new DatagramPacket(message, message.length, InetAddress.getByName(ip), port);
        try {
            serverSocket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        serverSocket.close();
    }

    public static void main(String[] args) {
        try {
            final String ip = args[0];
            final int port = Integer.parseInt(args[1]);
            Server server = new Server(ip, port);
            server.send();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
