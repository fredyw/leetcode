package leetcode;

/**
 * https://leetcode.com/problems/defanging-an-ip-address/
 */
public class Problem1108 {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
