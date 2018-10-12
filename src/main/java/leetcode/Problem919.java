package leetcode;

/**
 * https://leetcode.com/problems/complete-binary-tree-inserter/
 */
public class Problem919 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public static class CBTInserter {
        private final TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
        }

        public int insert(int v) {
            // TODO
            return 0;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        CBTInserter inserter = new CBTInserter(root);
        System.out.println(inserter.insert(4)); // 2
        System.out.println(inserter.insert(7)); // 3
        System.out.println(inserter.insert(8)); // 4
    }
}
