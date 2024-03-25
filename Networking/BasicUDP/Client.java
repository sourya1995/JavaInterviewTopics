package Networking.BasicUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress address = InetAddress.getByName(args[0]);
        String ex = "Hello, World";
        byte[] buf = ex.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 9876);
        clientSocket.send(packet);
        clientSocket.close();
    }
}
