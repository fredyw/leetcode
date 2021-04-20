package leetcode;

/**
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */
public class Problem1832 {
    public boolean checkIfPangram(String sentence) {
        int[] counts = new int[26];
        for (char c : sentence.toCharArray()) {
            counts[c - 'a']++;
        }
        for (int count : counts) {
            if (count == 0) {
                return false;
            }
        }
        return true;
    }
}
