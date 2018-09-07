package leetcode;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class Problem897 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    TreeNode cur;
//    public TreeNode increasingBST(TreeNode root) {
//        TreeNode ans = new TreeNode(0);
//        cur = ans;
//        inorder(root);
//        return ans.right;
//    }
//
//    public void inorder(TreeNode node) {
//        if (node == null) return;
//        inorder(node.left);
//        node.left = null;
//        cur = node;
//        cur.right = cur;
//        inorder(node.right);
//    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNodeRef ref = new TreeNodeRef();
        increasingBST(root, ref);
        return ref.root;
    }

    private static class TreeNodeRef {
        private TreeNode root;
        private TreeNode node;
    }

    private static void increasingBST(TreeNode node, TreeNodeRef ref) {
        if (node == null) {
            return;
        }
        increasingBST(node.left, ref);
        if (ref.root == null) {
            ref.root = node;
            ref.node = node;
        } else {
            ref.node.left = null;
            ref.node.right = node;
            ref.node = node;
        }
        increasingBST(node.right, ref);
    }

    private static void print(TreeNode node) {
        for (TreeNode n = node; n != null; n = n.right) {
            if (n.left != null) {
                throw new RuntimeException("Wrong!");
            }
            System.out.println(n.val);
        }
    }

    public static void main(String[] args) {
        Problem897 prob = new Problem897();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        print(prob.increasingBST(root));
        print(prob.increasingBST(new TreeNode(1)));
    }
}
