package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
 */
public class Problem1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] counts = new int[n];
        int prev = rounds[0] - 1;
        for (int i = 1; i < rounds.length; i++) {
            int j = prev;
            while (j != rounds[i] - 1) {
                counts[j]++;
                j = (j + 1) % n;
            }
            prev = rounds[i] - 1;
        }
        counts[prev]++;
        List<Integer> answer = new ArrayList<>();
        int max = Arrays.stream(counts).max().getAsInt();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == max) {
                answer.add(i + 1);
            }
        }
        return answer;
    }
}
