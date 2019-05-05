package leetcode;

/**
 * https://leetcode.com/problems/valid-boomerang/
 */
public class Problem1037 {
    public boolean isBoomerang(int[][] points) {
        // Note: slope of 2 points (x1, y1), (x2, y2)
        // (y2 - y2) / (x2 - x1)
        int[] a = points[0]; // (x1, y1)
        int[] b = points[1]; // (x2, y2)
        int[] c = points[2]; // (x3, y3)
        // (y2 − y1) / (x2 − x1) == (y3 − y1) / (x3 − x1)
        // (y2 − y1) * (x3 − x1) == (y3 − y1) * (x2 − x1)
        return !((b[1] - a[1]) * (c[0] - a[0]) == ((c[1] - a[1]) * (b[0] - a[0])));
    }
}
