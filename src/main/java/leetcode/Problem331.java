package leetcode;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 */
public class Problem331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        for (int i = 0; i < nodes.length; i++) {
            // TODO
        }
        return true;
    }

    public static void main(String[] args) {
        Problem331 prob = new Problem331();
        System.out.println(prob.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(prob.isValidSerialization("1,#"));
        System.out.println(prob.isValidSerialization("9,#,#,1"));
    }
}
