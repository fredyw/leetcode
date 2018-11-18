package leetcode;

/**
 * https://leetcode.com/problems/di-string-match/
 */
public class Problem942 {
    public int[] diStringMatch(String S) {
        int start = 0;
        int end = S.length();
        int[] result = new int[S.length() + 1];
        int index = 0;
        boolean increase = false;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                result[index] = start++;
                increase = true;
            } else { // S.charAt(i) == 'D'
                result[index] = end--;
                increase = false;
            }
            index++;
        }
        if (increase) {
            result[index] = start;
        } else {
            result[index] = end;
        }
        return result;
    }
}
