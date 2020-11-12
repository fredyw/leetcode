package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/throne-inheritance/
 */
public class Problem1600 {
    static class ThroneInheritance {
        private static class Node {
            private String name;
            private boolean death;
            private final List<Node> children = new ArrayList<>();

            public Node(String name) {
                this.name = name;
            }
        }

        private final Node root;
        private final Map<String, Node> nodes = new HashMap<>();

        public ThroneInheritance(String kingName) {
            root = new Node(kingName);
            nodes.put(kingName, root);
        }

        public void birth(String parentName, String childName) {
            Node parent = nodes.get(parentName);
            if (parent != null) {
                Node child = new Node(childName);
                parent.children.add(child);
                nodes.put(childName, child);
            }
        }

        public void death(String name) {
            Node node = nodes.get(name);
            if (node != null) {
                node.death = true;
            }
        }

        public List<String> getInheritanceOrder() {
            List<String> inheritance = new ArrayList<>();
            if (!root.death) {
                inheritance.add(root.name);
            }
            getInheritanceOrder(root, inheritance);
            return inheritance;
        }

        private static void getInheritanceOrder(Node parent, List<String> inheritance) {
            if (parent == null) {
                return;
            }
            for (Node child : parent.children) {
                if (!child.death) {
                    inheritance.add(child.name);
                }
                getInheritanceOrder(child, inheritance);
            }
        }
    }
}
