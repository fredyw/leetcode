package leetcode;

/**
 * https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
 */
public class Problem1736 {
    public String maximumTime(String time) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Problem1736 prob = new Problem1736();
        System.out.println(prob.maximumTime("2?:?0")); // "23:50"
        System.out.println(prob.maximumTime("0?:3?")); // "09:39"
        System.out.println(prob.maximumTime("1?:22")); // "19:22"
    }
}
