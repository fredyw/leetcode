package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/build-an-array-with-stack-operations/
 */
public class Problem1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n && j < target.length; i++) {
            if (i == target[j]) {
                answer.add("Push");
                j++;
            } else {
                answer.add("Push");
                answer.add("Pop");
            }
        }
        return answer;
    }
}
