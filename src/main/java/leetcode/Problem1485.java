package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/clone-binary-tree-with-random-pointer/
public class Problem1485 {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node random;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    public static class NodeCopy {
        int val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;

        NodeCopy(int val) {
            this.val = val;
        }

        NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> map = new HashMap<>();
        NodeCopy newRoot = copyBinaryTree(root, map);
        updateRandomNodes(root, newRoot, map);
        return newRoot;
    }

    private static NodeCopy copyBinaryTree(Node root, Map<Node, NodeCopy> map) {
        if (root == null) {
            return null;
        }
        NodeCopy newRoot = new NodeCopy(root.val);
        map.put(root, newRoot);
        newRoot.left = copyBinaryTree(root.left, map);
        newRoot.right = copyBinaryTree(root.right, map);
        return newRoot;
    }

    private static void updateRandomNodes(Node root, NodeCopy copyRoot, Map<Node, NodeCopy> map) {
        if (root == null) {
            return;
        }
        copyRoot.random = map.get(root.random);
        updateRandomNodes(root.left, copyRoot.left, map);
        updateRandomNodes(root.right, copyRoot.right, map);
    }
}
