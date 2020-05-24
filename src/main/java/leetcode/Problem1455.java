package leetcode;

/**
 * https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 */
public class Problem1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1455 prob = new Problem1455();
        System.out.println(prob.isPrefixOfWord("i love eating burger", "burg")); // 4
        System.out.println(prob.isPrefixOfWord("this problem is an easy problem", "pro")); // 2
        System.out.println(prob.isPrefixOfWord("i am tired", "you")); // -1
        System.out.println(prob.isPrefixOfWord("i use triple pillow", "pill")); // 4
        System.out.println(prob.isPrefixOfWord("hello from the other side", "they")); // -1
    }
}
