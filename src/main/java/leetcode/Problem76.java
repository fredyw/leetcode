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
                    begChar = s.charAt(begin);
                    begin++;
                }
                int window = end - begin + 1;
                if (window < minWindow) {
                    beginIdx = begin;
                    endIdx = end;
                    minWindow = window;
                }
            }
        }
        System.out.println(beginIdx + " " + endIdx);
        if (beginIdx == endIdx) {
            return "";
        }
        return s.substring(beginIdx, endIdx + 1);
    }

    public static void main(String[] args) {
        Problem76 prob = new Problem76();
        System.out.println(prob.minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(prob.minWindow("ADOBECODEBANC", "ABCX")); //
        System.out.println(prob.minWindow("AA", "AA")); // AA
    }
}
