import java.net.*;
import java.io.*;

public class Multi_Server {
    private static final String MULTICAST_GROUP = "230.0.0.0";
    private static final int PORT = 4446;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress group = InetAddress.getByName(MULTICAST_GROUP);
            String message = "Hello, multicast clients!";
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), group, PORT);
            socket.send(packet);
            System.out.println("Sent multicast message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
