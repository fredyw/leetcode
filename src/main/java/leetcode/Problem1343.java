package leetcode;

/**
 * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 */
public class Problem1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1343 prob = new Problem1343();
        System.out.println(prob.numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4)); // 3
        System.out.println(prob.numOfSubarrays(new int[]{1,1,1,1,1}, 1, 0)); // 5
        System.out.println(prob.numOfSubarrays(new int[]{11,13,17,23,29,31,7,5,2,3}, 3, 5)); // 6
        System.out.println(prob.numOfSubarrays(new int[]{7,7,7,7,7,7,7}, 7, 7)); // 1
        System.out.println(prob.numOfSubarrays(new int[]{4,4,4,4}, 4, 1)); // 1
    }
}
