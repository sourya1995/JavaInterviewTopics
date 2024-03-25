package Networking.BasicUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws SocketException {
        DatagramSocket serverSocket = new DatagramSocket(4160);
        byte[] rbuf = new byte[256];
        DatagramPacket packet = new DatagramPacket(rbuf, rbuf.length);
        while (true) {
            serverSocket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength()); // convert byte array to string
            System.out.println("Received: " + message);
        }

    }
}
