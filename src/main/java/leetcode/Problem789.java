package leetcode;

/**
 * https://leetcode.com/problems/escape-the-ghosts/
 */
public class Problem789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // https://en.wikipedia.org/wiki/Taxicab_geometry
        int ghostDistance = -1;
        for (int[] ghost : ghosts) {
            int d = taxi(ghost, target);
            if (ghostDistance == -1) {
                ghostDistance = d;
            } else {
                ghostDistance = Math.min(ghostDistance, d);
            }
        }
        int pacmanDistance = taxi(target, new int[]{0, 0});
        return pacmanDistance < ghostDistance;
    }

    private static int taxi(int[] p, int[] q) {
        return Math.abs(p[0] - q[0]) + Math.abs(p[1] - q[1]);
    }
}
