package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class Problem1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> edge : edges) {
            set.add(edge.get(1));
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                answer.add(i);
            }
        }
        return answer;
    }
}
