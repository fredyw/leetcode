package leetcode;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Problem153 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int minLeft = nums[left];
        if (mid - 1 >= 0) {
            minLeft = Math.min(minLeft, nums[mid - 1]);
        }
        int minRight = nums[right];
        if (mid + 1 < nums.length) {
            minRight = Math.min(minRight, nums[mid + 1]);
        }
        int min = Math.min(minLeft, Math.min(nums[mid], minRight));
        if (min == nums[mid]) {
            return nums[mid];
        }
        if (minLeft < minRight) {
            return findMin(nums, left, mid - 1);
        } else {
            return findMin(nums, mid + 1, right);
        }
    }
}
