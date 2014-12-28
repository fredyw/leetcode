package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class Problem107 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        class LevelNode {
            int level;
            TreeNode node;
            
            public LevelNode(int level, TreeNode node) {
                this.level = level;
                this.node = node;
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        LinkedList<LevelNode> linkedList = new LinkedList<>();
        linkedList.add(new LevelNode(0, root));
        while (!linkedList.isEmpty()) {
            LevelNode n = linkedList.removeFirst();
            if (!map.containsKey(n.level)) {
                List<Integer> list = new ArrayList<>();
                list.add(n.node.val);
                map.put(n.level, list);
            } else {
                map.get(n.level).add(n.node.val);
            }
            if (n.node.left != null) {
                linkedList.addLast(new LevelNode(n.level+1, n.node.left));
            }
            if (n.node.right != null) {
                linkedList.addLast(new LevelNode(n.level+1, n.node.right));
            }
        }
        for (int i = map.size()-1; i >= 0; i--) {
            result.add(map.get(i));
        }
        return result;
    }
}
