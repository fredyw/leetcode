package leetcode;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Problem154 {
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

    public static void main(String[] args) {
        Problem154 prob = new Problem154();
        System.out.println(prob.findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
//        System.out.println(prob.findMin(new int[]{4, 4, 5, 6, 7, 0, 1, 2, 2})); // 0
//        System.out.println(prob.findMin(new int[]{4, 4, 5, 6, 7, 2, 2, 3})); // 2
//        System.out.println(prob.findMin(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 1, 3})); // 1
    }
}
