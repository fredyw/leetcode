package leetcode;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */
public class Problem1347 {
    public int minSteps(String s, String t) {
        int[] countA = new int[26];
        for (char c : s.toCharArray()) {
            countA[c - 'a']++;
        }
        int[] countB = new int[26];
        for (char c : t.toCharArray()) {
            countB[c - 'a']++;
        }
        for (int i = 0; i < countA.length; i++) {
            if (countA[i] == countB[i]) {
                countA[i] = 0;
                countB[i] = 0;
            } else if (countA[i] < countB[i]) {
                countA[i] = 0;
                countB[i] -= countB[i];
            } else {
                countA[i] -= countB[i];
                countB[i] -= 0;
            }
        }
        int answer = 0;
        for (int i = 0; i < countA.length; i++) {
            answer += countA[i];
        }
        return answer;
    }
}
