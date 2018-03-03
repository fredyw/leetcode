package leetcode;

/**
 * https://leetcode.com/problems/escape-the-ghosts/
 */
public class Problem789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance1 = Integer.MAX_VALUE;
        for (int[] ghost : ghosts) {
            distance1 = Math.min(distance1, shortestPath(ghost, target));
        }
        int distance2 = shortestPath(new int[]{0, 0}, target);
        return distance2 < distance1;
    }

    private static int shortestPath(int[] source, int[] target) {
        return 0;
    }

    public static void main(String[] args) {
        Problem789 prob = new Problem789();
        System.out.println(prob.escapeGhosts(new int[][]{
            {1, 0},
            {0, 3}
        }, new int[]{0, 1})); // true
        System.out.println(prob.escapeGhosts(new int[][]{
            {1, 0},
        }, new int[]{2, 0})); // false
        System.out.println(prob.escapeGhosts(new int[][]{
            {2, 0},
        }, new int[]{1, 0})); // false
    }
}
