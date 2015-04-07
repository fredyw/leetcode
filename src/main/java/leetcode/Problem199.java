package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class Problem199 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        class TreeNodeLevel {
            TreeNode node;
            int level;
            
            public TreeNodeLevel(TreeNode node, int level) {
                this.node = node;
                this.level = level;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNodeLevel> list = new LinkedList<>();
        list.add(new TreeNodeLevel(root, 1));
        Map<Integer, Integer> map = new HashMap<>();
        while (!list.isEmpty()) {
            TreeNodeLevel n = list.remove();
            map.put(n.level, n.node.val);
            if (n.node.left != null) {
                list.add(new TreeNodeLevel(n.node.left, n.level+1));
            }
            if (n.node.right != null) {
                list.add(new TreeNodeLevel(n.node.right, n.level+1));
            }
        }
        for (int i = 1; i <= map.size(); i++) {
            result.add(map.get(i));
        }
        return result;
    }
}
