package leetcode;

/**
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/
 */
public class Problem1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] charsAllowed = new boolean[26];
        for (char c : allowed.toCharArray()) {
            charsAllowed[c - 'a'] = true;
        }
        int answer = 0;
        for (String word : words) {
            boolean consistent = true;
            for (char c : word.toCharArray()) {
                if (!charsAllowed[c - 'a']) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) {
                answer++;
            }
        }
        return answer;
    }
}
