package leetcode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 */
public class Problem889 {
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

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int[] preIndex = new int[pre.length + 1];
        for (int i = 0; i < pre.length; i++) {
            preIndex[pre[i]] = i;
        }
        return construct(pre, post, preIndex, new Index(post.length - 1), 0, post.length - 1);
    }

    private static class Index {
        private int val;

        public Index(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    private static TreeNode construct(int[] pre, int[] post, int[] preIndex, Index postIndex,
                                      int preBeginIndex, int preEndIndex) {
        if (preBeginIndex == preEndIndex) {
            return new TreeNode(pre[preBeginIndex]);
        }
        int index = preIndex[post[postIndex.val]];
        TreeNode node = new TreeNode(pre[index]);
        postIndex.val--;
        int midIndex = preIndex[post[postIndex.val]];
        node.right = construct(pre, post, preIndex, postIndex,
            midIndex, preEndIndex);
        postIndex.val--;
        node.left = construct(pre, post, preIndex, postIndex,
            preBeginIndex + 1, midIndex - 1);
        return node;
    }

    private static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    private static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    public static void main(String[] args) {
        Problem889 prob = new Problem889();
//        TreeNode root = prob.constructFromPrePost(
//            new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        TreeNode root = prob.constructFromPrePost(
            new int[]{1, 2, 4, 5, 3, 6, 8, 7, 9}, new int[]{4, 5, 2, 8, 6, 9, 7, 3, 1});

        preOrder(root);
        System.out.println();

        postOrder(root);
        System.out.println();

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//
//        preOrder(root);
//        System.out.println();
//
//        postOrder(root);
//        System.out.println();

//        root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        root.right.left.left = new TreeNode(8);
//        root.right.left.right = new TreeNode(10);
//        root.right.right.right = new TreeNode(9);
//
//        preOrder(root);
//        System.out.println();
//
//        postOrder(root);
//        System.out.println();
    }
}
