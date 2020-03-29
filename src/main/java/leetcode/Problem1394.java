package leetcode;

/**
 * https://leetcode.com/problems/find-lucky-integer-in-an-array/
 */
public class Problem1394 {
    public int findLucky(int[] arr) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1394 prob = new Problem1394();
        System.out.println(prob.findLucky(new int[]{2,2,3,4})); // 2
        System.out.println(prob.findLucky(new int[]{1,2,2,3,3,3})); // 3
        System.out.println(prob.findLucky(new int[]{2,2,2,3,3})); // -1
        System.out.println(prob.findLucky(new int[]{5})); // -1
        System.out.println(prob.findLucky(new int[]{7,7,7,7,7,7,7})); // 7
    }
}
