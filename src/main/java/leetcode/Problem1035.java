package leetcode;

/**
 * https://leetcode.com/problems/uncrossed-lines/
 */
public class Problem1035 {
    public int maxUncrossedLines(int[] A, int[] B) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1035 prob = new Problem1035();
        System.out.println(prob.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4})); // 2
        System.out.println(prob.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2})); // 3
        System.out.println(prob.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1})); // 2
    }
}
