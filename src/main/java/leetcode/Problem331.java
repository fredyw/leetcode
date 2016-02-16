package leetcode;

import java.util.Stack;

/**
w * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class Problem331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        Stack<Node> stack = new Stack<>();
        Direction direction = Direction.LEFT;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].equals("#")) {
                if (direction == Direction.LEFT) {
                    direction = Direction.RIGHT;
                } else {
                    direction = Direction.LEFT;
                }
                if (stack.size() == 0 && i < nodes.length - 1) {
                    return false;
                }
                if (i < nodes.length - 1) {
                    stack.pop().direction = direction;
                }
                continue;
            }
            Node node = new Node(nodes[i], direction);
            stack.add(node);
        }
        return stack.isEmpty();
    }

    private enum Direction {
        LEFT, RIGHT
    }

    private static class Node {
        private String node;
        private Direction direction;

        public Node(String node, Direction direction) {
            this.node = node;
            this.direction = direction;
        }
    }
}
