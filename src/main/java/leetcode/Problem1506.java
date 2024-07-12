package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-root-of-n-ary-tree/description/
public class Problem1506 {
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

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public Node findRoot(List<Node> tree) {
        // TODO
        return null;
    }
}
