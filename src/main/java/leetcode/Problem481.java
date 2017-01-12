package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/magical-string/
 */
public class Problem481 {
    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int result = 1;
        List<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(2);
        for (int i = 2; array.size() < n; i++) {
            int a = array.get(i);
            int add = array.get(array.size() - 1);
            if (add == 1) {
                add = 2;
            } else {
                add = 1;
                if (array.size() + (add * a) <= n) {
                    result += (add * a);
                } else {
                    result++;
                }
            }
            for (int j = 0; j < a; j++) {
                array.add(add);
            }
        }
        return result;
    }
}
