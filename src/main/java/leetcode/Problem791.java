package leetcode;

/**
 * https://leetcode.com/problems/custom-sort-string/
 */
public class Problem791 {
    public String customSortString(String S, String T) {
        int[] counts = new int[26];
        for (char c : T.toCharArray()) {
            counts[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : S.toCharArray()) {
            for (int i = 0; i < counts[c - 'a']; i++) {
                sb.append(c);
            }
            counts[c - 'a'] = 0;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = 0; j < counts[i]; j++) {
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return sb.toString();
    }
}
