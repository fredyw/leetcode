package leetcode;

/**
 * https://leetcode.com/problems/redundant-connection/
 */
public class Problem684 {
    public int[] findRedundantConnection(int[][] edges) {
        // TODO
        return new int[0];
    }

    public static void main(String[] args) {
        Problem684 prob = new Problem684();
        System.out.println(prob.findRedundantConnection(new int[][]{
            {1, 2}, {1, 3}, {2, 3}
        })); // [2,3]
        System.out.println(prob.findRedundantConnection(new int[][]{
            {1,2}, {2,3}, {3,4}, {1,4}, {1,5}
        })); // [1,4]
    }
}
