package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-unhappy-friends/
 */
public class Problem1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[] pairMap = new int[n];
        for (int[] pair : pairs) {
            pairMap[pair[0]] = pair[1];
            pairMap[pair[1]] = pair[0];
        }
        Map<Integer, Integer>[] preferenceMap = new Map[n];
        for (int i = 0; i < n; i++) {
            preferenceMap[i] = new HashMap<>();
            for (int j = 0; j < n - 1; j++) {
                preferenceMap[i].put(preferences[i][j], j);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j : preferences[i]) {
                if (preferenceMap[j].get(i) < preferenceMap[j].get(pairMap[j]) &&
                    preferenceMap[i].get(pairMap[i]) > preferenceMap[i].get(j)) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
