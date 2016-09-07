package leetcode;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class Problem394 {
    public String decodeString(String s) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Problem394 prob = new Problem394();
        System.out.println(prob.decodeString("3[a]2[bc]")); // aaabcbc
        System.out.println(prob.decodeString("3[a2[c]]")); // accaccacc
        System.out.println(prob.decodeString("2[abc]3[cd]ef")); // abcabccdcdcdef
    }
}
