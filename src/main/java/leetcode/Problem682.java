package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/baseball-game/
 */
public class Problem682 {
    public int calPoints(String[] ops) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("D")) {
                int a = list.get(list.size() - 1) * 2;
                list.add(a);
                sum += a;
            } else if (op.equals("C")) {
                int val = list.get(list.size() - 1);
                list.remove(list.size() - 1);
                sum -= val;
            } else if (op.equals("+")) {
                int a = list.get(list.size() - 1);
                int b = list.get(list.size() - 2);
                list.add(a + b);
                sum += (a + b);
            } else {
                list.add(Integer.parseInt(op));
                sum += Integer.parseInt(op);
            }
        }
        return sum;
    }
}
