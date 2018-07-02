package leetcode;

/**
 * https://leetcode.com/problems/loud-and-rich/
 */
public class Problem851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem851 prob = new Problem851();
        System.out.println(prob.loudAndRich(new int[][]{
            {1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}
        }, new int[]{3, 2, 5, 4, 6, 1, 7, 0})); // [5,5,2,5,4,5,6,7]
    }
}
