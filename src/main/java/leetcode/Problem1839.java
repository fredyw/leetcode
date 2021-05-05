package leetcode;

/**
 * https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/
 */
public class Problem1839 {
    public int longestBeautifulSubstring(String word) {
        int answer = 0;
        int count = 1;
        boolean[] vowels = new boolean[5];
        vowels[toIndex(word.charAt(0))] = true;
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) <= word.charAt(i + 1)) {
                count++;
            } else {
                count = 1;
                vowels = new boolean[5];
            }
            vowels[toIndex(word.charAt(i + 1))] = true;
            boolean allVowels = true;
            for (boolean vowel : vowels) {
                allVowels &= vowel;
            }
            if (allVowels) {
                answer = Math.max(answer, count);
            }
        }
        return answer;
    }

    private static int toIndex(char c) {
        if (c == 'a') {
            return 0;
        }
        if (c == 'e') {
            return 1;
        }
        if (c == 'i') {
            return 2;
        }
        if (c == 'o') {
            return 3;
        }
        return 4;
    }
}
