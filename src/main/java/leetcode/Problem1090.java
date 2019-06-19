package leetcode;

/**
 * https://leetcode.com/problems/largest-values-from-labels/
 */
public class Problem1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1090 prob = new Problem1090();
        System.out.println(prob.largestValsFromLabels(new int[]{5, 4, 3, 2, 1},
            new int[]{1, 1, 2, 2, 3}, 3, 1)); // 9
        System.out.println(prob.largestValsFromLabels(new int[]{5, 4, 3, 2, 1},
            new int[]{1, 3, 3, 3, 2}, 3, 2)); // 12
        System.out.println(prob.largestValsFromLabels(new int[]{5, 4, 3, 2, 1},
            new int[]{1, 3, 3, 3, 2}, 3, 1)); // 10
        System.out.println(prob.largestValsFromLabels(new int[]{9, 8, 8, 7, 6},
            new int[]{0, 0, 0, 1, 1}, 3, 1)); // 16
        System.out.println(prob.largestValsFromLabels(new int[]{9, 8, 8, 7, 6},
            new int[]{0, 0, 0, 1, 1}, 3, 2)); // 24
    }
}
