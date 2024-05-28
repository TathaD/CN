import java.net.InetAddress;
import java.net.*;
public class IP_Address{
    public static void main(String[] args){
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local IP Address: " + localHost.getHostAddress());
            InetAddress remoteHost = InetAddress.getByName("www.google.com");
            System.out.println("Remote IP Address (www.google.com): " + remoteHost.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}