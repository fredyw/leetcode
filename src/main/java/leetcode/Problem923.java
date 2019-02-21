package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/3sum-with-multiplicity/
 */
public class Problem923 {
    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], new ArrayList<>());
            }
            map.get(A[i]).add(i);
        }
        long answer = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int k = target - (A[i] + A[j]);
                List<Integer> list = map.get(k);
                if (list != null) {
                    int index = Collections.binarySearch(list, j + 1);
                    if (index < 0) {
                        index = -index - 1;
                    }
                    answer += list.size() - index;
                }
            }
        }
        return (int) (answer % (1e9 + 7));
    }
}
