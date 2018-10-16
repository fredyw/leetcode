package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-subsets/
 */
public class Problem916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        int[] countB = new int[26];
        for (String b : B) {
            int[] tmp = new int[26];
            for (char c : b.toCharArray()) {
                tmp[c - 'a']++;
                countB[c - 'a'] = Math.max(countB[c - 'a'], tmp[c - 'a']);
            }
        }
        outer:
        for (String a : A) {
            int[] countA = new int[26];
            for (char c : a.toCharArray()) {
                countA[c - 'a']++;
            }
            for (int i = 0; i < countB.length; i++) {
                countA[i] -= countB[i];
                if (countA[i] < 0) {
                    continue outer;
                }
            }
            result.add(a);
        }
        return result;
    }
}
