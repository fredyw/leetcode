package leetcode;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/
 */
public class Problem434 {
    public int countSegments(String s) {
        if (s.trim().isEmpty()) {
            return 0;
        }
        return s.trim().split("\\s+").length;
    }
}
