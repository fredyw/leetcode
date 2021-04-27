package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/finding-the-users-active-minutes/
 */
public class Problem1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] answer = new int[k];
        Map</* user */ Integer, Set</* UAM */ Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            int user = log[0];
            int time = log[1];
            map.putIfAbsent(user, new HashSet<>());
            map.get(user).add(time);
        }
        for (Set<Integer> uamSet : map.values()) {
            answer[uamSet.size() - 1]++;
        }
        return answer;
    }
}
