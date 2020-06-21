package leetcode;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 */
public class Problem1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1481 prob = new Problem1481();
        System.out.println(prob.findLeastNumOfUniqueInts(new int[]{5,5,4}, 1)); // 1
        System.out.println(prob.findLeastNumOfUniqueInts(new int[]{5,5,4}, 2)); // 1
        System.out.println(prob.findLeastNumOfUniqueInts(new int[]{5,5,4,6}, 2)); // 1
        System.out.println(prob.findLeastNumOfUniqueInts(new int[]{5,5,4,6}, 3)); // 1
        System.out.println(prob.findLeastNumOfUniqueInts(new int[]{5,5,4,4,6}, 4)); // 1
        System.out.println(prob.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3)); // 2
    }
}
