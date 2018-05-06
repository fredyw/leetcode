package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/positions-of-large-groups/
 */
public class Problem830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        int prevIdx = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i == 0) {
                prevIdx = 0;
                count++;
            } else {
                if (S.charAt(prevIdx) == S.charAt(i)) {
                    count++;
                } else {
                    if (count >= 3) {
                        result.add(Arrays.asList(prevIdx, i - 1));
                    }
                    count = 1;
                    prevIdx = i;
                }
            }
        }
        if (count >= 3) {
            result.add(Arrays.asList(prevIdx, S.length() - 1));
        }
        return result;
    }
}
