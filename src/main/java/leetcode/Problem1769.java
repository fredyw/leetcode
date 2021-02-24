package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 */
public class Problem1769 {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                indexes.add(i);
            }
        }
        for (int i = 0; i < boxes.length(); i++) {
            int count = 0;
            for (int index : indexes) {
                if (index == i || boxes.charAt(index) == '0') {
                    continue;
                }
                count += Math.abs(i - index);
            }
            answer[i] = count;
        }
        return answer;
    }
}
