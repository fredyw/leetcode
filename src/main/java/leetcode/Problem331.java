package leetcode;

import java.util.Stack;

/**
w * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class Problem331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals("#")) {
                if (stack.size() == 0 && i < nodes.length - 1) {
                    return false;
                }
                if (i < nodes.length - 1) {
                    stack.pop();
                }
                continue;
            }
            stack.add(nodes[i]);
        }
        return stack.isEmpty();
    }
}
