package leetcode;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class Problem76 {
    public String minWindow(String s, String t) {
        int size = 128;
        int[] needed = new int[size];
        for (char c : t.toCharArray()) {
            needed[c]++;
        }
        int[] found = new int[size];
        int count = 0;
        int minWindow = Integer.MAX_VALUE;
        int beginIdx = 0;
        int endIdx = 0;
        int begin = 0;
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            if (needed[endChar] == 0) {
                continue;
            }
            found[endChar]++;
            if (found[endChar] <= needed[endChar]) {
                count++;
            }
            if (count == t.length()) {
                char begChar = s.charAt(begin);
                while (found[begChar] == 0 || needed[begChar] < found[begChar]) {
                    if (needed[begChar] < found[begChar]) {
                        found[begChar]--;
                    }
                    begin++;
                    begChar = s.charAt(begin);
                }
                int window = end - begin + 1;
                if (window < minWindow) {
                    beginIdx = begin;
                    endIdx = end;
                    minWindow = window;
                }
            }
        }
        if (beginIdx == endIdx && count != t.length()) {
            return "";
        }
        return s.substring(beginIdx, endIdx + 1);
    }
}
