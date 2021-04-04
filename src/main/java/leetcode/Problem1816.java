package leetcode;

/**
 * https://leetcode.com/problems/truncate-sentence/
 */
public class Problem1816 {
    public String truncateSentence(String s, int k) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1816 prob = new Problem1816();
        System.out.println(prob.truncateSentence("Hello how are you Contestant", 4)); // "Hello how are you"
        System.out.println(prob.truncateSentence("What is the solution to this problem", 4)); // "What is the solution"
        System.out.println(prob.truncateSentence("chopper is not a tanuki", 5)); // "chopper is not a tanuki"
    }
}
