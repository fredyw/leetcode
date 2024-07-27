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
        // TODO
        return 0;
    }
}
