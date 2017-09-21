package leetcode;

/**
 * https://leetcode.com/problems/validate-ip-address/
 */
public class Problem468 {
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            if (isValidIPv4(IP)) {
                return "IPv4";
            }
            return "Neither";
        }
        if (isValidIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean isValidIPv6(String ip) {
        // TODO
        return false;
    }

    private static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            int number = Integer.parseInt(part);
            if (0 <= number && number <= 255) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem468 prob = new Problem468();
        System.out.println(prob.validIPAddress("172.16.254.1")); // IPv4
        System.out.println(prob.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")); // IPv6
        System.out.println(prob.validIPAddress("256.256.256.256")); // Neither
    }
}
