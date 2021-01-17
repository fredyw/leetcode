package leetcode;

/**
 * https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 */
public class Problem1725 {
    public int countGoodRectangles(int[][] rectangles) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1725 prob = new Problem1725();
        System.out.println(prob.countGoodRectangles(new int[][]{
            {5,8},{3,9},{5,12},{16,5}
        })); // 3
        System.out.println(prob.countGoodRectangles(new int[][]{
            {2,3},{3,7},{4,3},{3,7}
        })); // 3
    }
}
