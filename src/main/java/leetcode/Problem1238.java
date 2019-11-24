package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/circular-permutation-in-binary-representation/
 */
public class Problem1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> answer = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < Math.pow(2, n); i++) {
            int grayCode = binaryToGray(i);
            if (grayCode == start) {
                index = i;
            }
            answer.add(grayCode);
        }
        Collections.rotate(answer, -index);
        return answer;
    }

    private static int binaryToGray(int n) {
        // https://en.wikipedia.org/wiki/Gray_code
        return n ^ (n >> 1);
    }
}
