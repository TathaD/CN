import java.io.*;
import java.net.*;

public class Echo_Server {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started and listening on port " + PORT);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                    String input = in.readLine();
                    System.out.println("Received: " + input);
                    out.println(input);
                    System.out.println("Echoed: " + input);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
