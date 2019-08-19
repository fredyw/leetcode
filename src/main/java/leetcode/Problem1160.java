package leetcode;

/**
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class Problem1160 {
    public int countCharacters(String[] words, String chars) {
        int answer = 0;
        for (String word : words) {
            if (word.length() > chars.length()) {
                continue;
            }
            int[] counts = counts(chars);
            boolean found = true;
            for (char c : word.toCharArray()) {
                if (counts[c - 'a'] == 0) {
                    found = false;
                    break;
                } else {
                    counts[c - 'a']--;
                }
            }
            if (found) {
                answer += word.length();
            }
        }
        return answer;
    }

    private static int[] counts(String chars) {
        int[] counts = new int[26];
        for (char c : chars.toCharArray()) {
           counts[c - 'a']++;
        }
        return counts;
    }
}
