package leetcode;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        IntRef result = new IntRef();
        findKthLargest(nums, nums.length-k, 0, nums.length-1, result);
        return result.result;
    }
    
    private static class IntRef {
        int result;
    }
    
    private void findKthLargest(int[] nums, int k, int left, int right, IntRef result) {
        if (left > right) {
            return;
        }
        int p = partition(nums, left, right);
        if (p == k) {
            result.result = nums[p];
        }
        findKthLargest(nums, k, left, p-1, result);
        findKthLargest(nums, k, p+1, right, result);
    }
    
    private int partition(int[] nums, int left, int right) {
        int originalLeft = left;
        int originalRight = right;
        int p = nums[originalLeft];
        while (true) {
            while (left < originalRight && nums[left] <= p) {
                left++;
            }
            while (right > originalLeft && nums[right] >= p) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
            } else {
                break;
            }
        }
        swap(nums, originalLeft, right);
        return right;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
