package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class Problem914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : deck) {
            int count = map.getOrDefault(val, 0) + 1;
            map.put(val, count);
        }
        int gcd = -1;
        for (int count : map.values()) {
            if (count < 2) {
                return false;
            }
            if (gcd == -1) {
                gcd = count;
            } else if (gcd != count) {
                gcd = gcd(gcd, count);
                if (gcd == 1) {
                    return false;
                }
            }
        }
        for (int count : map.values()) {
            if (count % gcd != 0) {
                return false;
            }
        }
        return true;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
