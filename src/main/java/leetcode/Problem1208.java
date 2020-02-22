package leetcode;

/**
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 */
public class Problem1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1208 prob = new Problem1208();
        System.out.println(prob.equalSubstring("abcd", "bcdf", 3)); // 3
        System.out.println(prob.equalSubstring("abcd", "cdef", 3)); // 1
        System.out.println(prob.equalSubstring("abcd", "acde", 0)); // 1
    }
}
