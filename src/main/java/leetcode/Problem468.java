package leetcode;

/**
 * https://leetcode.com/problems/validate-ip-address/
 */
public class Problem468 {
    public String validIPAddress(String IP) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem468 prob = new Problem468();
        System.out.println(prob.validIPAddress("172.16.254.1")); // IPv4
        System.out.println(prob.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")); // IPv6
        System.out.println(prob.validIPAddress("256.256.256.256")); // Neither
    }
}
