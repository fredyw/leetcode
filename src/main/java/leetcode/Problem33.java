package leetcode;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Problem33 {
    public int search(int[] nums, int target) {
        int prev = 0;
        int current;
        for (current = 1; current < nums.length; current++) {
            if (nums[current] < nums[prev]) {
                break;
            }
            prev = current;
        }
        int startIdx = current;
        if (current == nums.length) {
            startIdx = 0;
        }
        return binarySearch(nums, target, 0, nums.length-1, startIdx);
    }

    private int binarySearch(int[] nums, int target, int lo, int hi, int startIdx) {
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) / 2;
        int midIdx = startIdx + mid;
        if (midIdx >= nums.length) {
            midIdx = midIdx - nums.length;
        }
        if (nums[midIdx] == target) {
            return midIdx;
        }
        if (nums[midIdx] > target) {
            return binarySearch(nums, target, lo, mid-1, startIdx);
        }
        return binarySearch(nums, target, mid+1, hi, startIdx);
    }
}
