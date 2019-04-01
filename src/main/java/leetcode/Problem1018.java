package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-prefix-divisible-by-5/
 */
public class Problem1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> answer = new ArrayList<>();
        int remainder = 0;
        for (int i = 0; i < A.length; i++) {
            remainder = A[i] == 0 ? (remainder * 2) % 5 : (remainder * 2 + 1) % 5;
            answer.add(remainder == 0);
        }
        return answer;
    }
}
