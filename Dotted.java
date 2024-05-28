public class Dotted {
    public static void main(String[] args) {
        String ipAddress = "11000000.10101000.00000001.00000001"; // Binary format example
        // String ipAddress = "192.168.1.1"; // Dotted decimal format example

        if (ipAddress.contains(".")) {
            if (ipAddress.split("\\.")[0].length() > 8) {
                ipAddress = binaryToDecimal(ipAddress);
            }
        }

        String[] parts = ipAddress.split("\\.");
        int firstOctet = Integer.parseInt(parts[0]);
        char ipClass;
        String networkId;

        if (firstOctet >= 1 && firstOctet <= 126) {
            ipClass = 'A';
            networkId = parts[0] + ".0.0.0";
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            ipClass = 'B';
            networkId = parts[0] + "." + parts[1] + ".0.0";
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            ipClass = 'C';
            networkId = parts[0] + "." + parts[1] + "." + parts[2] + ".0";
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            ipClass = 'D';
            networkId = "N/A";
        } else {
            ipClass = 'E';
            networkId = "N/A";
        }

        System.out.println("IP Address: " + ipAddress);
        System.out.println("Class: " + ipClass);
        System.out.println("Network ID: " + networkId);
    }

    private static String binaryToDecimal(String binary) {
        String[] parts = binary.split("\\.");
        StringBuilder decimalIp = new StringBuilder();
        for (String part : parts) {
            decimalIp.append(Integer.parseInt(part, 2)).append(".");
        }
        return decimalIp.substring(0, decimalIp.length() - 1);
    }
}
