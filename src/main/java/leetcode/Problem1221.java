package leetcode;

/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
public class Problem1221 {
    public int balancedStringSplit(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1221 prob = new Problem1221();
        System.out.println(prob.balancedStringSplit("RLRRLLRLRL")); // 4
        System.out.println(prob.balancedStringSplit("RLLLLRRRLR")); // 3
        System.out.println(prob.balancedStringSplit("LLLLRRRR")); // 1
    }
}
