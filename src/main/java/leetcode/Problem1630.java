package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/arithmetic-subarrays/
 */
public class Problem1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] sub = new int[r[i] - l[i] + 1];
            for (int j = l[i], k = 0; j <= r[i]; j++, k++) {
                sub[k] = nums[j];
            }
            Arrays.sort(sub);
            int diff = 0;
            boolean valid = true;
            for (int j = 0; j < sub.length - 1; j++) {
                if (j == 0) {
                    diff = sub[j + 1] - sub[j];
                } else {
                    int newDiff = sub[j + 1] - sub[j];
                    if (diff != newDiff) {
                        valid = false;
                        break;
                    }
                }
            }
            answer.add(valid);
        }
        return answer;
    }
}
