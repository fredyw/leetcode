package leetcode;

/**
 * https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/
 */
public class Problem1545 {
    public char findKthBit(int n, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1545 prob = new Problem1545();
        System.out.println(prob.findKthBit(3, 1)); // "0"
        System.out.println(prob.findKthBit(4, 11)); // "1"
        System.out.println(prob.findKthBit(1, 1)); // "0"
        System.out.println(prob.findKthBit(2, 3)); // "1"
    }
}
