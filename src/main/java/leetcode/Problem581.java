package leetcode;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class Problem581 {
    public int findUnsortedSubarray(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

        }
        return 0;
    }

    public static void main(String[] args) {
        Problem581 prob = new Problem581();
        System.out.println(prob.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15})); // 5
        System.out.println(prob.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 7, 9})); // 6    
    }
}
