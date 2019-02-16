package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 */
public class Problem955 {
    public int minDeletionSize(String[] A) {
        int n = A[0].length();
        int answer = 0;
        String[] strings = new String[A.length];
        Arrays.fill(strings, "");
        for (int i = 0; i < n; i++) {
            String[] tmp = Arrays.copyOf(strings, A.length);
            for (int j = 0; j < A.length; j++) {
                tmp[j] += A[j].charAt(i);
            }
            if (!isSorted(tmp)) {
                answer++;
            } else {
                strings = tmp;
            }
        }
        return answer;
    }

    private static boolean isSorted(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i].compareTo(strings[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}
