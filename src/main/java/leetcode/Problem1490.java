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

        public Node(int _val,ArrayList<Node> children) {
            val = _val;
            this.children = children;
        }
    }

    public Node cloneTree(Node root) {
        // TODO
        return null;
    }
}
