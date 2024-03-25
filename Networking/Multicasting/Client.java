package Networking.Multicasting;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client {
    private MulticastSocket socket;

    public Client(String host, int port) throws Exception {
        socket = new MulticastSocket(port);
        socket.joinGroup(InetAddress.getByName(host));
    }

    public void printMessage(){
        byte[] message = new byte[256];
        DatagramPacket packet = new DatagramPacket(message, message.length);
        try {
            socket.receive(packet);
            String str = new String(packet.getData());
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    public void close() {
        socket.close();
    
    }
    
}
