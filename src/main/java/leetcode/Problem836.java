package leetcode;

/**
 * https://leetcode.com/problems/rectangle-overlap/
 */
public class Problem836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (rec1[0] < rec2[0] && rec2[0] < rec1[2] ||
                rec1[0] < rec2[2] && rec2[2] < rec1[2]) &&
               (rec1[1] < rec2[1] && rec2[1] < rec2[3] ||
                rec1[1] < rec2[3] && rec2[3] < rec2[3]);
    }

    public static void main(String[] args) {
        Problem836 prob = new Problem836();
        System.out.println(prob.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3})); // true
        System.out.println(prob.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1})); // false
        System.out.println(prob.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{0, 0, 2, 1})); // false
        System.out.println(prob.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{0, 1, 1, 1})); // false
        System.out.println(prob.isRectangleOverlap(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20})); // true
    }
}
