package leetcode;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length-1);
    }
    
    private int searchInsert(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            return searchInsert(nums, target, left, mid-1);
        } else { // target > nums[mid]
            return searchInsert(nums, target, mid+1, right);
        }
    }
}
