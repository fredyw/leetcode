package leetcode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Problem116 {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {

    }
    
    public static void main(String[] args) {
        Problem116 prob = new Problem116();
        
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        
        prob.connect(root);
        
        for (TreeLinkNode node = root.left; node != null; node = node.next) {
            System.out.println(node.val);
        }
        System.out.println("-------------------------------------------------");
        for (TreeLinkNode node = root.left.left; node != null; node = node.next) {
            System.out.println(node.val);
        }
    }
}
