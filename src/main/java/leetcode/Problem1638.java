package leetcode;

/**
 * https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
 */
public class Problem1638 {
    public int countSubstrings(String s, String t) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int count = 0;
                for (int k = i, l = j; k < s.length() && l < t.length(); k++, l++) {
                    if (s.charAt(k) != t.charAt(l)) {
                        count++;
                    }
                    if (count > 1) {
                        break;
                    }
                    answer += count;
                }
            }
        }
        return answer;
    }
}
