package leetcode;

/**
 * https://leetcode.com/problems/validate-ip-address/
 */
public class Problem468 {
    public String validIPAddress(String IP) {
        String ip = IP.toLowerCase();
        if (ip.contains(".")) {
            if (isValidIPv4(ip)) {
                return "IPv4";
            }
            return "Neither";
        }
        if (isValidIPv6(ip)) {
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean isValidIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) {
            return false;
        }
        for (String part : parts) {
            if (part.length() > 4) {
                return false;
            }
            if (!isHex(part)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isHex(String str) {
        if (str.equals("+0") || str.equals("-0")) {
            return false;
        }
        try {
            Integer.parseInt(str, 16);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) {
            return false;
        }
        for (String part : parts) {
            if (part.startsWith("0") && part.length() > 1) {
                return false;
            }
            if (!isNumber(part)) {
                return false;
            }
            int number = Integer.parseInt(part);
            if (number < 0 || number > 255) {
                return false;
            }
        }
        return true;
    }

    private static boolean isNumber(String str) {
        if (str.equals("+0") || str.equals("-0")) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
