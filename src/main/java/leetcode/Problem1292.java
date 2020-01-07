package leetcode;

/**
 * https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 */
public class Problem1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1292 prob = new Problem1292();
        System.out.println(prob.maxSideLength(new int[][]{
            {1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}
        }, 4)); // 2
        System.out.println(prob.maxSideLength(new int[][]{
            {2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2},{2,2,2,2,2}
        }, 1)); // 0
        System.out.println(prob.maxSideLength(new int[][]{
            {1,1,1,1},{1,0,0,0},{1,0,0,0},{1,0,0,0}
        }, 6)); // 3
        System.out.println(prob.maxSideLength(new int[][]{
            {18,70},{61,1},{25,85},{14,40},{11,96},{97,96},{63,45}
        }, 40184)); // 2
        System.out.println(prob.maxSideLength(new int[][]{
            {18,70},{61,1}
        }, 4)); // 1
        System.out.println(prob.maxSideLength(new int[][]{
            {18,70},{61,5}
        }, 4)); // 0
    }
}
