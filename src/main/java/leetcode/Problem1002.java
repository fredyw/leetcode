package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-common-characters/
 */
public class Problem1002 {
    public List<String> commonChars(String[] A) {
        int[][] counts = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                counts[i][A[i].charAt(j) - 'a']++;
            }
        }
        List<String> answer = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            int min = Integer.MAX_VALUE;
            for (int[] count : counts) {
                min = Math.min(min, count[c - 'a']);
            }
            for (int i = 0; i < min; i++) {
                answer.add("" + c);
            }
        }
        return answer;
    }
}
