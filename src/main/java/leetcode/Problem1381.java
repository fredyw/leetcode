package leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/
 */
public class Problem1381 {
    static class CustomStack {
        private final int maxSize;
        private final LinkedList<IntWrapper> list = new LinkedList<>();

        private static class IntWrapper {
            private int value;

            public IntWrapper(int value) {
                this.value = value;
            }
        }

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (list.size() == maxSize) {
                return;
            }
            list.push(new IntWrapper(x));
        }

        public int pop() {
            if (list.size() == 0) {
                return -1;
            }
            return list.removeFirst().value;
        }

        public void increment(int k, int val) {
            Iterator<IntWrapper> iter = list.descendingIterator();
            int i = 0;
            while (i < k && iter.hasNext()) {
                IntWrapper iw = iter.next();
                iw.value += val;
                i++;
            }
        }
    }
}
