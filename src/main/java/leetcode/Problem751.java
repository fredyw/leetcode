package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/ip-to-cidr/
 */
public class Problem751 {
    public List<String> ipToCIDR(String ip, int n) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem751 prob = new Problem751();
        System.out.println(prob.ipToCIDR("255.0.0.7", 10)); // ["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
    }
}
