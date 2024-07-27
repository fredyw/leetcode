package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/diameter-of-n-ary-tree/
public class Problem1522 {
    public static class Node {
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

    public int diameter(Node root) {
        Diameter diameter = new Diameter();
        diameter(root, diameter);
        return diameter.val;
    }

    private static class Diameter {
        private int val;
    }

    private static int diameter(Node root, Diameter diameter) {
        if (root == null) {
            return 0;
        }
        int firstMaxDepth = 0;
        int secondMaxDepth = 0;
        for (Node child : root.children) {
            int depth = diameter(child, diameter) + 1;
            if (firstMaxDepth == 0) {
                firstMaxDepth = depth;
                diameter.val = Math.max(diameter.val, firstMaxDepth);
            } else if (firstMaxDepth <= depth) {
                secondMaxDepth = firstMaxDepth;
                firstMaxDepth = depth;
                diameter.val = Math.max(diameter.val, firstMaxDepth + secondMaxDepth);
            } else if (secondMaxDepth < firstMaxDepth) {
                secondMaxDepth = Math.max(secondMaxDepth, depth);
                diameter.val = Math.max(diameter.val, firstMaxDepth + secondMaxDepth);
            }
        }
        return firstMaxDepth;
    }
}
