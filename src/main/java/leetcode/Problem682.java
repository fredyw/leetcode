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
        int index = 0;
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("D")) {
                int a = list.get(list.size() - 1) * 2;
                sum += a;
                list.add(sum);
            } else if (op.equals("C")) {
                sum -= Integer.parseInt(ops[index]);
                list.remove(list.size() - 1);
            } else if (op.equals("+")) {
                int a = list.get(list.size() - 1);
                int b = list.get(list.size() - 2);
                sum += (a + b);
                list.add(sum);
            } else {
                index = i;
                sum += Integer.parseInt(op);
                list.add(sum);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Problem682 prob = new Problem682();
        System.out.println(prob.calPoints(new String[]{"5", "2", "C", "D", "+"})); // 15
        System.out.println(prob.calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"})); // 27
    }
}
