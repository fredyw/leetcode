package leetcode;

/**
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/
 */
public class Problem1415 {
    public String getHappyString(int n, int k) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Problem1415 prob = new Problem1415();
        System.out.println(prob.getHappyString(1, 3)); // "c"
        System.out.println(prob.getHappyString(1, 4)); // ""
        System.out.println(prob.getHappyString(3, 9)); // "cab"
        System.out.println(prob.getHappyString(2, 7)); // ""
        System.out.println(prob.getHappyString(10, 100)); // "abacbabacb"
        System.out.println(prob.getHappyString(4, 1)); // "abab"
    }
}
