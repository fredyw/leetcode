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
        Stack<Integer>[] stack = new Stack[n];
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            String type = split[1];
            int time = Integer.parseInt(split[2]);
            if (stack[id] == null) {
                stack[id] = new Stack<>();
            }
            if (type.equals("start")) {
                stack[id].add(time);
            } else {
                result[id] += time - stack[id].pop();
            }
        }
        return result;
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
    }
}
