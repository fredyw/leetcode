package leetcode;

/**
 * https://leetcode.com/problems/prison-cells-after-n-days/
 */
public class Problem957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem957 prob = new Problem957();
        System.out.println(prob.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 7)); // [0,0,1,1,0,0,0,0]
        System.out.println(prob.prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000)); // [0,0,1,1,1,1,1,0]
    }
}
