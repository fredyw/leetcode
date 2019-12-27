package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
 */
public class Problem1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        int up = upper;
        int lo = lower;
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                answer.get(0).add(1);
                answer.get(1).add(1);
                up--;
                lo--;
                if (up < 0 || lo < 0) {
                    return Collections.emptyList();
                }
            } else {
                answer.get(0).add(0);
                answer.get(1).add(0);
            }
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (up > 0) {
                    answer.get(0).set(i, 1);
                    up--;
                } else if (lo > 0) {
                    answer.get(1).set(i, 1);
                    lo--;
                } else {
                    return Collections.emptyList();
                }
            }
        }
        return up == 0 && lo == 0 ? answer : Collections.emptyList();
    }
}
