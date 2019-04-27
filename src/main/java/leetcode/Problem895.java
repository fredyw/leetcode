package leetcode;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 */
public class Problem895 {
    private static class FreqStack {
        public FreqStack() {
        }

        public void push(int x) {
            // TODO
        }

        public int pop() {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop()); // 5
        System.out.println(stack.pop()); // 7
        System.out.println(stack.pop()); // 5
        System.out.println(stack.pop()); // 4
    }
}
