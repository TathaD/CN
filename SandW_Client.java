import java.io.*;
import java.net.*;

public class SandW_Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             DataInputStream dis = new DataInputStream(socket.getInputStream());
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            for (int i = 1; i <= 5; i++) {
                dos.writeInt(i); // Send packet
                System.out.println("Sent packet: " + i);
                int ack = dis.readInt(); // Receive ack
                System.out.println("Received ack: " + ack);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
