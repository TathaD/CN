import java.io.*;
import java.net.*;
import java.util.Date;

public class Server_Side_Socket{
    private static final int PORT = 6000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started and listening on port " + PORT);
            while (true) {
                try (Socket socket = serverSocket.accept();
                     DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

                    System.out.println("Connection established with client");
                    Date currentDate = new Date();
                    dos.writeUTF(currentDate.toString());
                    System.out.println("Sent current date and time: " + currentDate);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
