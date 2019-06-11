package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/letter-tile-possibilities/
 */
public class Problem1079 {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        numTilePossibilities(tiles, "", new boolean[tiles.length()], set);
        return set.size();
    }

    private static void numTilePossibilities(String tiles, String accu, boolean[] visited,
                                            Set<String> set) {
        if (accu.length() == tiles.length()) {
            return;
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            String newStr = accu + tiles.charAt(i);
            set.add(newStr);
            numTilePossibilities(tiles, newStr, visited, set);
            visited[i] = false;
        }
    }
}
