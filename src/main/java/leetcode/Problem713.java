package leetcode;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class Problem713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int totalProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            totalProduct *= nums[i];
        }
        if (totalProduct < k) {
            result++;
        }
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int leftProduct = 1;
            for (int x = i; x < j; x++) {
                leftProduct *= nums[x];
                if (leftProduct < k) {
                    result++;
                }
                if (totalProduct / leftProduct < k) {
                    result++;
                }
            }
            totalProduct /= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Problem713 prob = new Problem713();
        System.out.println(prob.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100)); // 8
    }
}
