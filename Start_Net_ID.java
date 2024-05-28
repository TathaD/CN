import java.net.InetAddress;
import java.net.UnknownHostException;

public class Start_Net_ID{
    public static void main(String[] args) {
        String ipAddress = "192.168.1.1";
        int subnetMask = 24; // For example: 255.255.255.0

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            byte[] address = inetAddress.getAddress();

            int mask = 0xFFFFFFFF << (32 - subnetMask);
            int ip = (address[0] & 0xFF) << 24 | (address[1] & 0xFF) << 16 | (address[2] & 0xFF) << 8 | (address[3] & 0xFF);

            int networkId = ip & mask;
            int startNetworkId = networkId;

            System.out.println("IP Address: " + ipAddress);
            System.out.println("Subnet Mask: " + subnetMask);
            System.out.println("Starting Network ID: " + intToIp(startNetworkId));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static String intToIp(int ip) {
        return ((ip >> 24) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                (ip & 0xFF);
    }
}

