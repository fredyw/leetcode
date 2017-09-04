package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 */
public class Problem636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<FunctionTime> stack = new Stack<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            String type = split[1];
            int time = Integer.parseInt(split[2]);
            if (type.equals("start")) {
                if (!stack.isEmpty()) {
                    FunctionTime ft = stack.peek();
                    result[ft.id] += time - ft.val;
                }
                stack.push(new FunctionTime(id, time));
            } else {
            }
        }
        return result;
    }

    private static class FunctionTime {
        private final int id;
        private final int val;

        public FunctionTime(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Problem636 prob = new Problem636();
        System.out.println(Arrays.toString(prob.exclusiveTime(2, Arrays.asList(
            "0:start:0",
            "1:start:2",
            "1:end:5",
            "0:end:6"
        )))); // [3, 4]
        System.out.println(Arrays.toString(prob.exclusiveTime(2, Arrays.asList(
            "0:start:0",
            "0:end:2",
            "1:start:5",
            "1:end:6"
        )))); // [3, 2]
        System.out.println(Arrays.toString(prob.exclusiveTime(3, Arrays.asList(
            "0:start:0",
            "1:start:2",
            "2:start:4",
            "1:end:6",
            "2:end:8",
            "2:end:10"
        )))); // [[4, 4, 3]
    }
}
