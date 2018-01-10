package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-anagram-mappings/
 */
public class Problem760 {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(B[i], list);
            } else {
                map.get(B[i]).add(i);
            }
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            LinkedList<Integer> list = map.get(A[i]);
            Integer idx = list.removeFirst();
            result[i] = idx;
        }
        return result;
    }
}
