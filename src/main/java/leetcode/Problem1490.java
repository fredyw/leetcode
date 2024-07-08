package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/clone-n-ary-tree/
public class Problem1490 {
    private static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }
        Node node = new Node(root.val);
        List<Node> children = new ArrayList<>();
        for (Node child : root.children) {
            children.add(cloneTree(child));
        }
        node.children = children;
        return node;
    }
}
