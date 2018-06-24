package leetcode;

/**
 * https://leetcode.com/problems/buddy-strings/
 */
public class Problem859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int idx1 = 0;
        int idx2 = 0;
        int count = 0;
        int[] charCounts = new int[26];
        boolean hasDuplicate = false;
        for (int i = 0; i < A.length(); i++) {
            int index = A.charAt(i) - 'a';
            charCounts[index]++;
            if (charCounts[index] > 1) {
                hasDuplicate = true;
            }
            if (A.charAt(i) != B.charAt(i)) {
                if (count == 0) {
                    idx1 = i;
                } else if (count == 1) {
                    idx2 = i;
                } else {
                    return false;
                }
                count++;
            }
        }
        if (count == 0) {
            return hasDuplicate;
        }
        return (A.charAt(idx1) == B.charAt(idx2) &&
            A.charAt(idx2) == B.charAt(idx1));
    }
}
