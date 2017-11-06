package leetcode;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class Problem720 {
    public String longestWord(String[] words) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Problem720 prob = new Problem720();
        System.out.println(prob.longestWord(new String[]{"w","wo","wor","worl", "world"})); // world
        System.out.println(prob.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"})); // apple
    }
}
