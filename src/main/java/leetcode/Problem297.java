package leetcode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Problem297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return "";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return null;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1);
        String serializedTree = codec.serialize(root);
        System.out.println(serializedTree);
        codec.deserialize(serializedTree);
    }
}
