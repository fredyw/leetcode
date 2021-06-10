package leetcode;

/**
 * https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
 */
public class Problem1880 {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return toNumber(firstWord) + toNumber(secondWord) == toNumber(targetWord);
    }

    private static long toNumber(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(c - 'a');
        }
        return Long.parseLong(sb.toString());
    }
}
