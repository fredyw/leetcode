package leetcode;

/**
 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
 */
public class Problem1876 {
    public int countGoodSubstrings(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 3 > s.length()) {
                continue;
            }
            String sub = s.substring(i, i + 3);
            if (isDistinct(sub)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isDistinct(String s) {
        return s.charAt(0) != s.charAt(1)
            && s.charAt(0) != s.charAt(2)
            && s.charAt(1) != s.charAt(2);
    }
}
