package leetcode;

/**
 * https://leetcode.com/problems/maximum-number-of-balloons/
 */
public class Problem1189 {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (char c : text.toCharArray()) {
            counts[c - 'a']++;
        }
        int answer = 0;
        boolean found = true;
        while (found) {
            if (counts['b' - 'a'] >= 1 && counts['a' - 'a'] >= 1 &&
                counts['l' - 'a'] >= 2 && counts['o' - 'a'] >= 2 &&
                counts['n' - 'a'] >= 1) {
                counts['b' - 'a']--;
                counts['a' - 'a']--;
                counts['l' - 'a'] -= 2;
                counts['o' - 'a'] -= 2;
                counts['n' - 'a']--;
                answer++;
            } else {
                found = false;
            }
        }
        return answer;
    }
}
