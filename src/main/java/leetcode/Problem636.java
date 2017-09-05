package leetcode;

import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/exclusive-time-of-functions/
 */
public class Problem636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int previousTime = 0;
        int previousId = 0;
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            String type = split[1];
            int time = Integer.parseInt(split[2]);
            if (type.equals("end")) {
                time++;
            }
            result[previousId] += time - previousTime;
            if (type.equals("start")) {
                stack.push(previousId);
                previousId = id;
            } else {
                previousId = stack.pop();
            }
            previousTime = time;
        }
        return result;
    }
}
