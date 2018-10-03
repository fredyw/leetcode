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
    }

    private static TreeNode construct(int[] pre, int[] post, int[] preIndex, Index postIndex,
                                      int preBeginIndex, int preEndIndex) {
        if (preBeginIndex > preEndIndex) {
            postIndex.val++;
            return null;
        }
        if (preBeginIndex == preEndIndex) {
            return new TreeNode(pre[preBeginIndex]);
        }
        int index = preIndex[post[postIndex.val]];
        TreeNode node = new TreeNode(pre[index]);
        postIndex.val--;
        int preMidIndex = preIndex[post[postIndex.val]];
        node.right = construct(pre, post, preIndex, postIndex,
            preMidIndex, preEndIndex);
        postIndex.val--;
        node.left = construct(pre, post, preIndex, postIndex,
            preBeginIndex + 1, preMidIndex - 1);
        return node;
    }
}
