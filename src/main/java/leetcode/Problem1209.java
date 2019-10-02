package leetcode;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class Problem1209 {
    public String removeDuplicates(String s, int k) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1209 prob = new Problem1209();
        System.out.println(prob.removeDuplicates("abcd", 2)); // "abcd"
        System.out.println(prob.removeDuplicates("deeedbbcccbdaa", 3)); // "aa"
        System.out.println(prob.removeDuplicates("pbbcggttciiippooaais", 2)); // "ps"
    }
}
