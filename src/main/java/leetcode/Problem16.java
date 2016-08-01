package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class Problem16 {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int diff = Integer.MAX_VALUE;
        int threeSum = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (i == j) {
                    continue;
                }
                int expected = target - (num[i] + num[j]);
                int closest = modifiedBinarySearch(num, expected);
                if (i == closest || j == closest) {
                    continue;
                }
                int sum = num[i] + num[j] + num[closest];
                if ((Math.abs(target - sum)) < diff) {
                    diff = Math.abs(target - sum);
                    threeSum = sum;
                }
            }
        }
        return threeSum;
    }

    private int modifiedBinarySearch(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (num[mid] < target) {
                left = mid + 1;
            } else if (num[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return mid;
    }
}
