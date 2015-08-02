package leetcode;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class Problem64 {
    public int minPathSum(int[][] grid) {
    	// TODO: to be implemented
        return 0;
    }
    
    public static void main(String[] args) {
		Problem64 prob = new Problem64();
		int[][] grid = new int[][] {
			new int[]{1, 9, 4, 7},
			new int[]{6, 2, 1, 5},
			new int[]{1, 3, 8, 2}
		};
		System.out.println(prob.minPathSum(grid));
	}
}
