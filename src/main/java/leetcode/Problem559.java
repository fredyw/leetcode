package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class Problem559 {
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem559 prob = new Problem559();
    }
}
