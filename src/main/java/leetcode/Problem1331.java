package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/rank-transform-of-an-array/
 */
public class Problem1331 {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int rank = 1;
        Map</* value= */ Integer, /* rank= */ Integer> map = new HashMap<>();
        for (int n : set) {
            map.put(n, rank);
            rank++;
        }
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = map.get(arr[i]);
        }
        return answer;
    }
}
