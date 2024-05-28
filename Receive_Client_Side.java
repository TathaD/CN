import java.io.*;
import java.net.*;

public class Receive_Client_Side {
    private static final int PORT = 6000;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            String date = dis.readUTF();
            System.out.println("Received from server: " + date);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
