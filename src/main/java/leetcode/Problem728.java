package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/self-dividing-numbers/
 */
public class Problem728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String str = "" + i;
            boolean found = true;
            for (int j = 0; j < str.length(); j++) {
                int a = str.charAt(j) - '0';
                if (a == 0 || i % a != 0) {
                    found = false;
                    break;
                }
            }
            if (found) {
                result.add(i);
            }
        }
        return result;
    }
}
