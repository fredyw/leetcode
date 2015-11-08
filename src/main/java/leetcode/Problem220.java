package leetcode;

/**
 * https://leetcode.com/problems/contains-duplicate-iii/
 */
public class Problem220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= (i + k) && j < nums.length; j++) {
                int diff = Math.abs(nums[j] - nums[i]);
                if (diff <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem220 prob = new Problem220();
        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{0}, 0, 0)); // false
        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{1}, 1, 1)); // false
        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{-1, -1}, 1, 0)); // true
        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{2, 1}, 1, 1)); // true
        System.out.println(prob.containsNearbyAlmostDuplicate(new int[]{4, 2}, 2, 1)); // false
    }
}
