package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 */
public class Problem228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int n = nums[0];
        int tmp = n;
        for (int i = 1; i < nums.length; i++) {
            if (tmp+1 != nums[i]) {
                if (n == tmp) {
                    result.add("" + n);
                } else {
                    result.add(n + "->" + tmp);
                }
                n = nums[i];
                tmp = n;
            } else {
                tmp++;
            }
        }
        if (n == tmp) {
            result.add("" + n);
        } else {
            result.add(n + "->" + tmp);
        }
        return result;
    }
}
