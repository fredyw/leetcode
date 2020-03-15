package leetcode;

/**
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/
 */
public class Problem1381 {
    static class CustomStack {
        public CustomStack(int maxSize) {
        }

        public void push(int x) {
            // TODO
        }

        public int pop() {
            // TODO
            return 0;
        }

        public void increment(int k, int val) {
            // TODO
        }
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop()); // 2
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        System.out.println(stack.pop()); // 103
        System.out.println(stack.pop()); // 202
        System.out.println(stack.pop()); // 201
        System.out.println(stack.pop()); // -1
    }
}
