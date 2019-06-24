package leetcode;

/**
 * https://leetcode.com/problems/car-pooling/
 */
public class Problem1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1094 prob = new Problem1094();
        System.out.println(prob.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4)); // false
        System.out.println(prob.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5)); // true
        System.out.println(prob.carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3)); // true
        System.out.println(prob.carPooling(new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11)); // true
    }
}
