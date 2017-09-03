package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 */
public class Problem636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        // TODO
        return result;
    }

    public static void main(String[] args) {
        Problem636 prob = new Problem636();
        System.out.println(prob.exclusiveTime(2, Arrays.asList(
            "0:start:0",
            "1:start:2",
            "1:end:5",
            "0:end:6"
        ))); // [3, 4]
    }
}
