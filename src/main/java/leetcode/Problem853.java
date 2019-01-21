package leetcode;

/**
 * https://leetcode.com/problems/car-fleet/
 */
public class Problem853 {
    public int carFleet(int target, int[] position, int[] speed) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem853 prob = new Problem853();
//        System.out.println(prob.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3})); // 3
//        System.out.println(prob.carFleet(12, new int[]{10, 7, 0, 5, 3}, new int[]{2, 4, 1, 1, 3})); // 4
//        System.out.println(prob.carFleet(12, new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1})); // 1
//        System.out.println(prob.carFleet(15, new int[]{4, 5}, new int[]{2, 1})); // 1
//        System.out.println(prob.carFleet(10, new int[]{2, 4}, new int[]{3, 2})); // 1
        System.out.println(prob.carFleet(31, new int[]{5, 26, 18, 25, 29, 21, 22, 12, 19, 6}, new int[]{7, 6, 6, 4, 3, 4, 9, 7, 6, 4})); // 6
    }
}
