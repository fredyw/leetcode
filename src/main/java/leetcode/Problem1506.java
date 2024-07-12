package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
        Set<Integer> set = new HashSet<>();
        for (Node node : tree) {
            for (Node child : node.children) {
                set.add(child.val);
            }
        }
        for (Node node : tree) {
            if (!set.contains(node.val)) {
                return node;
            }
        }
        return null;
    }
}
