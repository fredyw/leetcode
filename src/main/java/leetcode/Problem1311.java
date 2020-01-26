package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/get-watched-videos-by-your-friends/
 */
public class Problem1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,
                                               int[][] friends,
                                               int id,
                                               int level) {
        Map<String, Integer> countMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int count = 0;
        boolean[] visited = new boolean[friends.length];
        visited[id] = true;
        while (!queue.isEmpty()) {
            if (count == level) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int p = queue.poll();
                for (int friend : friends[p]) {
                    if (!visited[friend]) {
                        queue.add(friend);
                        visited[friend] = true;
                    }
                }
            }
            count++;
        }
        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(countMap.entrySet());
        Collections.sort(sorted, (a, b) -> {
            int cmp = Integer.compare(a.getValue(), b.getValue());
            if (cmp == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return cmp;
        });
        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> e : sorted) {
            answer.add(e.getKey());
        }
        return answer;
    }
}
