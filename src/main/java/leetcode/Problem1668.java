package leetcode;

/**
 * https://leetcode.com/problems/maximum-repeating-substring/
 */
public class Problem1668 {
    public int maxRepeating(String sequence, String word) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1668 prob = new Problem1668();
        System.out.println(prob.maxRepeating("ababc", "ab")); // 2
        System.out.println(prob.maxRepeating("ababc", "ba")); // 1
        System.out.println(prob.maxRepeating("ababc", "ac")); // 0
    }
}
