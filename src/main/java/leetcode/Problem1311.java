package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/get-watched-videos-by-your-friends/
 */
public class Problem1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,
                                               int[][] friends,
                                               int id,
                                               int level) {
        Map<String, Integer> countMap = new HashMap<>();
        watchedVideos(watchedVideos, friends, id, level, 0, new boolean[friends.length], countMap);
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

    private static void watchedVideos(List<List<String>> watchedVideos,
                                      int[][] friends, int id, int targetLevel, int level,
                                      boolean[] visited,
                                      Map<String, Integer> countMap) {
        if (visited[id]) {
            return;
        }
        visited[id] = true;
        if (level == targetLevel) {
            for (String video : watchedVideos.get(id)) {
                countMap.put(video, countMap.getOrDefault(video, 0) + 1);
            }
            return;
        }
        for (int friend : friends[id]) {
            watchedVideos(watchedVideos, friends, friend, targetLevel, level + 1, visited, countMap);
        }
    }

    public static void main(String[] args) {
        Problem1311 prob = new Problem1311();
        System.out.println(prob.watchedVideosByFriends(
            Arrays.asList(
                Arrays.asList("A", "B"), Arrays.asList("C"), Arrays.asList("B", "C"), Arrays.asList("D")
            ), new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 1)); // ["B","C"]
        System.out.println(prob.watchedVideosByFriends(
            Arrays.asList(
                Arrays.asList("A", "B"), Arrays.asList("C"), Arrays.asList("B", "C"), Arrays.asList("D")
            ), new int[][]{{1, 2, 3}, {0, 3}, {0, 3}, {0, 1, 2}}, 0, 1)); // ["B","D","C"]
        System.out.println(prob.watchedVideosByFriends(
            Arrays.asList(
                Arrays.asList("A", "B"), Arrays.asList("A", "B", "C"), Arrays.asList("B", "C"), Arrays.asList("D")
            ), new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 1)); // ["A","B","C"]
        System.out.println(prob.watchedVideosByFriends(
            Arrays.asList(
                Arrays.asList("A", "B"), Arrays.asList("C"), Arrays.asList("B", "C"), Arrays.asList("D")
            ), new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 2)); // ["D"]
    }
}
