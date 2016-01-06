package leetcode;

/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */
public class Problem318 {
    public int maxProduct(String[] words) {
        // TODO:
        return 0;
    }

    public static void main(String[] args) {
        Problem318 prob = new Problem318();
        System.out.println(prob.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})); // 16
        System.out.println(prob.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"})); // 4
        System.out.println(prob.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})); // 0
    }
}
