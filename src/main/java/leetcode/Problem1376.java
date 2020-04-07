package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/time-needed-to-inform-all-employees/
 */
public class Problem1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[manager.length];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                graph[manager[i]].add(i);
            }
        }
        return numOfMinutes(graph, informTime, headID);
    }

    private static int numOfMinutes(List<Integer>[] graph, int[] informTime, int head) {
        int answer = 0;
        for (int child : graph[head]) {
            answer = Math.max(answer, numOfMinutes(graph, informTime, child) + informTime[head]);
        }
        return answer;
    }
}
