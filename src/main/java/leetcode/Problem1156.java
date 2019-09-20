package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
 */
public class Problem1156 {
    public int maxRepOpt1(String text) {
        List<Integer>[] charIndexes = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            charIndexes[i] = new ArrayList<>();
        }
        int n = text.length();
        for (int i = 0; i < n; i++) {
            charIndexes[text.charAt(i) - 'a'].add(i);
        }
        int answer = 1;
        for (int i = 0; i < 26; i++) {
            int current = 1;
            int previous = 0;
            int max = 0;
            for (int j = 1; j < charIndexes[i].size(); j++) {
                if (charIndexes[i].get(j) == charIndexes[i].get(j - 1) + 1) {
                    current++;
                } else {
                    previous = charIndexes[i].get(j) == charIndexes[i].get(j - 1) + 2 ? current : 0;
                    current = 1;
                }
                max = Math.max(max, current + previous);
            }
            answer = Math.max(answer, max + (charIndexes[i].size() > max ? 1 : 0));
        }
        return answer;
    }
}
