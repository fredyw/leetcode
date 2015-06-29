package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class Problem202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return isHappy(n, set);
    }
    
    private boolean isHappy(int n, Set<Integer> set) {
        if (n == 1) {
            return true;
        }
        if (set.contains(n)) {
            return false;
        }
        set.add(n);
        String s = Integer.toString(n);
        int val = 0;
        for (char c : s.toCharArray()) {
            int num = Integer.parseInt(Character.toString(c));
            val += num * num;
        }
        return isHappy(val, set);
    }
}
