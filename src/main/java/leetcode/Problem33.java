package leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Problem33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int idx = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                idx = i + 1;
                break;
            }
        }
        return binarySearch(nums, target, idx, 0, nums.length);
    }

    private static int binarySearch(int[] nums, int target, int idx, int i, int j) {
        int left = i;
        int right = j;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = nums[(mid + idx) % nums.length];
            if (midValue == target) {
                return (mid + idx) % nums.length;
            } else if (midValue < target) {
                left = mid + 1;
            } else { // midValue >= target
                right = mid - 1;
            }
        }
        return -1;
    }
}
