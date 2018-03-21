package leetcode;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class Problem792 {
    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        for (String word : words) {
            int i = 0;
            int j = 0;
            int count = 0;
            for (; i < word.length(); i++) {
                while (j < S.length()) {
                    if (word.charAt(i) == S.charAt(j++)) {
                        count++;
                        break;
                    }
                }
                if (j == S.length()) {
                    break;
                }
            }
            if (count == word.length()) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem792 prob = new Problem792();
        System.out.println(prob.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"})); // 3
    }
}
