package leetcode;

/**
 * https://leetcode.com/problems/the-kth-factor-of-n/
 */
public class Problem1492 {
    public int kthFactor(int n, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1492 prob = new Problem1492();
        System.out.println(prob.kthFactor(12, 3)); // 3
        System.out.println(prob.kthFactor(7, 2)); // 7
        System.out.println(prob.kthFactor(4, 4)); // -1
        System.out.println(prob.kthFactor(1, 1)); // 1
        System.out.println(prob.kthFactor(1000, 3)); // 4
    }
}
