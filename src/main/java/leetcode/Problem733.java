package leetcode;

/**
 * https://leetcode.com/problems/flood-fill/
 */
public class Problem733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem733 prob = new Problem733();
        System.out.println(prob.floodFill(new int[][]{
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}}, 1, 1, 2)); // [[2,2,2],[2,2,0],[2,0,1]]
    }
}
