package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 */
public class Problem895 {
    private static class FreqStack {
        private final Map<Integer /*number*/, Integer /*count*/> numCounts = new HashMap<>();
        private final Map<Integer /*count*/, Stack<Integer>> countStack = new HashMap<>();
        private int maxCount = 0;

        public FreqStack() {
        }

        public void push(int x) {
            int count;
            if (!numCounts.containsKey(x)) {
                count = 1;
                numCounts.put(x, count);
            } else {
                count = numCounts.get(x) + 1;
                numCounts.put(x, count);
            }

            if (!countStack.containsKey(count)) {
                Stack<Integer> stack = new Stack<>();
                stack.add(x);
                countStack.put(count, stack);
            } else {
                countStack.get(count).add(x);
            }
            maxCount = Math.max(maxCount, count);
        }

        public int pop() {
            Stack<Integer> stack = countStack.get(maxCount);
            int val = stack.pop();
            if (stack.isEmpty()) {
                countStack.remove(maxCount--);
            }
            int count = numCounts.get(val) - 1;
            if (count == 0) {
                numCounts.remove(val);
            } else {
                numCounts.put(val, count);
            }
            return val;
        }
    }
}
