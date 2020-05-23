package leetcode;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class Problem1456 {
    public int maxVowels(String s, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
                s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                max++;
            }
        }
        int answer = max;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                max++;
            }
            if (isVowel(s.charAt(i - k))) {
                max--;
            }
            answer = Math.max(answer, max);
        }
        return answer;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
