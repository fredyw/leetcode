package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/simplified-fractions/
 */
public class Problem1447 {
    public List<String> simplifiedFractions(int n) {
        List<String> answer = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int x = gcd(i, j);
                if (x != 1 && i % x == 0 && j % x == 0) {
                    continue;
                }
                answer.add(i + "/" + j);
            }
        }
        return answer;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
