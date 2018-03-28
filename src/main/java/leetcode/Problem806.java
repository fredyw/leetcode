package leetcode;

/**
 * https://leetcode.com/problems/number-of-lines-to-write-string/
 */
public class Problem806 {
    public int[] numberOfLines(int[] widths, String S) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem806 prob = new Problem806();
        System.out.println(prob.numberOfLines(new int[]{
            10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
            "abcdefghijklmnopqrstuvwxyz")); // [3, 6]
        System.out.println(prob.numberOfLines(new int[]{
            4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
            "bbbcccdddaaa"
        )); // [2, 4]
    }
}
