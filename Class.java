public class Class {
    public static void main(String[] args) {
        String ipAddress = "192.168.1.1";
        String[] parts = ipAddress.split("\\.");

        int firstOctet = Integer.parseInt(parts[0]);
        char ipClass;
        String networkId;
        String hostId;

        if (firstOctet >= 1 && firstOctet <= 126) {
            ipClass = 'A';
            networkId = parts[0];
            hostId = parts[1] + "." + parts[2] + "." + parts[3];
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            ipClass = 'B';
            networkId = parts[0] + "." + parts[1];
            hostId = parts[2] + "." + parts[3];
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            ipClass = 'C';
            networkId = parts[0] + "." + parts[1] + "." + parts[2];
            hostId = parts[3];
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            ipClass = 'D';
            networkId = "N/A";
            hostId = "N/A";
        } else {
            ipClass = 'E';
            networkId = "N/A";
            hostId = "N/A";
        }

        System.out.println("IP Address: " + ipAddress);
        System.out.println("Class: " + ipClass);
        System.out.println("Network ID: " + networkId);
        System.out.println("Host ID: " + hostId);
    }
}
