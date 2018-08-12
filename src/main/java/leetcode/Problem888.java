package leetcode;

/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 */
public class Problem888 {
    public String[] uncommonFromSentences(String A, String B) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem888 prob = new Problem888();
        System.out.println(prob.uncommonFromSentences("this apple is sweet", "this apple is sour")); // ["sweet","sour"]
        System.out.println(prob.uncommonFromSentences("apple apple", "banana")); // ["banana"]
    }
}
