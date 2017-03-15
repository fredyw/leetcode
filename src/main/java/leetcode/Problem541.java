package leetcode;

/**
 * https://leetcode.com/problems/reverse-string-ii/
 */
public class Problem541 {
    public String reverseStr(String s, int k) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Problem541 prob = new Problem541();
        System.out.println(prob.reverseStr("abcdefg", 2)); // bacdfeg
        System.out.println(prob.reverseStr("abcdefghij", 2)); // bacdfeghji
        System.out.println(prob.reverseStr("abcdefghij", 3)); // cbadefihgj
        System.out.println(prob.reverseStr("abcdefghij", 20)); // jihgfedcba
    }
}
