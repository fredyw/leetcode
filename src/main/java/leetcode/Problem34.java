package leetcode;

/**
 * https://leetcode.com/problems/search-for-a-range/
 */
public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int[] result = new int[2];
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                int left = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                if (left == 0 && nums[left] == target) {
                    result[0] = left;
                } else {
                    result[0] = left + 1;
                }
                int right = mid;
                while (right <= nums.length - 1 && nums[right] == target) {
                    right++;
                }
                if (right == nums.length - 1 && nums[right] == target) {
                    result[1] = right;
                } else {
                    result[1] = right - 1;
                }
                return result;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else { // nums[mid] > target
                hi = mid - 1;
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }
}
