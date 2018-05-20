package leetcode;

/**
 * https://leetcode.com/problems/rectangle-overlap/
 */
public class Problem836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean xIntersect =
            rec1[0] < rec2[0] && rec2[0] < rec1[2] ||
            rec1[0] < rec2[2] && rec2[2] < rec1[2] ||
            rec2[0] < rec1[0] && rec1[0] < rec2[2] ||
            rec2[0] < rec1[2] && rec1[2] < rec2[2];
        boolean yIntersect =
            rec1[1] < rec2[1] && rec2[1] < rec1[3] ||
            rec1[1] < rec2[3] && rec2[3] < rec1[3] ||
            rec2[1] < rec1[1] && rec1[1] < rec2[3] ||
            rec2[1] < rec1[3] && rec1[3] < rec2[3];
        return xIntersect && yIntersect;
    }
}
