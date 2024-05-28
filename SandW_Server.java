import java.io.*;
import java.net.*;

public class SandW_Server {
    private static final int PORT = 8000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started and listening on port " + PORT);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream dis = new DataInputStream(socket.getInputStream());
                     DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

                    int packet = dis.readInt();
                    System.out.println("Received packet: " + packet);
                    dos.writeInt(packet); // Send ack
                    System.out.println("Sent ack: " + packet);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
