package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
 */
public class Problem1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int level = (int) (Math.log10(label) / Math.log10(2));
        List<Integer> answer = new ArrayList<>();
        while (label != 0) {
            answer.add(label);
            int left = (int) Math.pow(2, level - 1);
            int right = (int) Math.pow(2, level) - 1;
            label = left + (right - label / 2);
            level--;
        }
        Collections.reverse(answer);
        return answer;
    }
}
