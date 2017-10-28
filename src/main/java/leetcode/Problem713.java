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
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            if (totalProduct < k) {
                result++;
            }
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
            totalProduct /= nums[j];
        }
        return result;
    }

    public static void main(String[] args) {
        Problem713 prob = new Problem713();
        System.out.println(prob.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100)); // 8
        System.out.println(prob.numSubarrayProductLessThanK(new int[]{1, 1, 1, 1}, 10)); // 10
        System.out.println(prob.numSubarrayProductLessThanK(new int[]{2, 1, 3, 5}, 10)); // 7
    }
}
