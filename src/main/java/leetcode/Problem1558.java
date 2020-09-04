package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/
 */
public class Problem1558 {
    public int minOperations(int[] nums) {
        int answer = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int m = max;
        while (m > 1) {
            if (m % 2 != 0) {
                answer++; // plus 1 for any odd numbers
            }
            m /= 2;
            answer++; // multiply all by 2
        }
        int maxCount = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            answer++; // plus 1 from 0
            if (num == max) {
                maxCount++;
                if (maxCount == 1) {
                    continue;
                }
            }
            while (num > 1) {
                if (num % 2 != 0) {
                    answer++; // plus 1 for any odd numbers
                }
                num /= 2;
            }
        }
        return answer;
    }
}
