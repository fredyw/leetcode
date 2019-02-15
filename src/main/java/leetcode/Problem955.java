package leetcode;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
 */
public class Problem955 {
    public int minDeletionSize(String[] A) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem955 prob = new Problem955();
        System.out.println(prob.minDeletionSize(new String[]{"ca", "bb", "ac"})); // 1
        System.out.println(prob.minDeletionSize(new String[]{"xc", "yb", "za"})); // 0
        System.out.println(prob.minDeletionSize(new String[]{"zyx","wvu","tsr"})); // 3
        System.out.println(prob.minDeletionSize(new String[]{"abcdef", "uvwxyz"})); // 0
    }
}
