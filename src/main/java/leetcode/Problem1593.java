package leetcode;

/**
 * https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
 */
public class Problem1593 {
    public int maxUniqueSplit(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1593 prob = new Problem1593();
        System.out.println(prob.maxUniqueSplit("ababccc")); // 5
        System.out.println(prob.maxUniqueSplit("aba")); // 2
        System.out.println(prob.maxUniqueSplit("aa")); // 1
    }
}
