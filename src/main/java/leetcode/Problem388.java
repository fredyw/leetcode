package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 */
public class Problem388 {
    public int lengthLongestPath(String input) {
        String[] split = input.split("\\n");
        Map<Integer, Integer> levelToLengthMap = new HashMap<>();
        // TODO
        for (String s : split) {
            int idx = 0;
            int currentLevel = 0;
            while (s.charAt(idx++) == '\t') {
                currentLevel++;
            }
            int parentLevel = currentLevel - 1;
            int length = 0;
            if (parentLevel >= 0) {
                length = levelToLengthMap.get(parentLevel) + 1;
            }
            length += s.length() - currentLevel;
            levelToLengthMap.put(currentLevel, length);
        }
        int max = 0;
        for (int length : levelToLengthMap.values()) {
            max = Math.max(max, length);
        }
        return max;
    }

    private static class LevelLength {
        private final int level;
        private final int length;

        public LevelLength(int level, int length) {
            this.level = level;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        Problem388 prob = new Problem388();
        System.out.println(prob.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext")); // 32
    }
}
