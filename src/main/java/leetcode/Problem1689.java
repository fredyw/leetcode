package leetcode;

/**
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */
public class Problem1689 {
    public int minPartitions(String n) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1689 prob = new Problem1689();
        System.out.println(prob.minPartitions("32")); // 3
        System.out.println(prob.minPartitions("82734")); // 8
        System.out.println(prob.minPartitions("27346209830709182346")); // 9
    }
}
