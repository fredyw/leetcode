package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/get-watched-videos-by-your-friends/
 */
public class Problem1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,
                                               int[][] friends,
                                               int id,
                                               int level) {
        // TODO
        return null;
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
            ), new int[][]{{1, 2}, {0, 3}, {0, 3}, {1, 2}}, 0, 2)); // ["D"]
    }
}
