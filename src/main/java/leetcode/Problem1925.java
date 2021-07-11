package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-square-sum-triples/
 */
public class Problem1925 {
    public int countTriples(int n) {
        Set</* square */ Integer> squares = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            squares.add(i * i);
        }
        int answer = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 2; b <= n; b++) {
                // a^2 + b^2 = c^2
                int c = (a * a) + (b * b);
                if (squares.contains(c)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
