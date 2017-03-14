package leetcode;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class Problem410 {
    public int splitArray(int[] nums, int m) {
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
        int[] sumSubArrays = new int[m];
        return splitArray(nums, sums, m, 0, 0, sumSubArrays);
    }

    private static int splitArray(int[] nums, int[] sums, int m, int idx,
                                  int sumSubArrayIdx, int[] sumSubArrays) {
        if (m <= 1) {
            sumSubArrays[sumSubArrayIdx] = sums[nums.length - 1];
            int max = 0;
            for (int i = sumSubArrays.length - 1; i >= 0; i--) {
                if (i == 0) {
                    max = Math.max(max, sumSubArrays[i]);
                } else {
                    max = Math.max(max, sumSubArrays[i] - sumSubArrays[i - 1]);
                }
            }
            return max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = idx; i < nums.length; i++) {
            sumSubArrays[sumSubArrayIdx] = sums[i];
            min = Math.min(min, splitArray(nums, sums, m - 1, i + 1,
                sumSubArrayIdx + 1, sumSubArrays));
        }
        return min;
    }

    public static void main(String[] args) {
        Problem410 prob = new Problem410();
        System.out.println(prob.splitArray(new int[]{7, 2, 5, 10, 8}, 2)); // 18
        System.out.println(prob.splitArray(new int[]{7, 2, 5, 10, 8}, 3)); // 14
        System.out.println(prob.splitArray(new int[]{7, 2, 5, 10, 8}, 4)); // 10
        System.out.println(prob.splitArray(new int[]{7, 2, 5, 10, 8}, 5)); // 10
        System.out.println(prob.splitArray(new int[]{1, 2, 4, 5, 6, 10, 2, 4, 10, 4}, 8)); // 10
        System.out.println(prob.splitArray(new int[]{1, 2, 3, 4}, 3)); // 4
    }
}
