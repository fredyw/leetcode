package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/path-crossing/
 */
public class Problem1496 {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int row = 0;
        int col = 0;
        set.add(row + "," + col);
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                row--;
            } else if (c == 'E') {
                col++;
            } else if (c == 'S') {
                row++;
            } else { // if (c == 'W)
                col--;
            }
            String key = row + "," + col;
            if (set.contains(key)) {
                return true;
            }
            set.add(key);
        }
        return false;
    }
}
