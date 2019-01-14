package leetcode;

/**
 * https://leetcode.com/problems/largest-perimeter-triangle/
 */
public class Problem976 {
    public int largestPerimeter(int[] A) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem976 prob = new Problem976();
        System.out.println(prob.largestPerimeter(new int[]{2, 1, 2})); // 5
        System.out.println(prob.largestPerimeter(new int[]{1, 2, 1})); // 0
        System.out.println(prob.largestPerimeter(new int[]{3, 2, 3, 4})); // 10
        System.out.println(prob.largestPerimeter(new int[]{3, 6, 2, 3})); // 8
    }
}
