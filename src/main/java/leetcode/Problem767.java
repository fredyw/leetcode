package leetcode;

/**
 * https://leetcode.com/problems/reorganize-string/
 */
public class Problem767 {
    public String reorganizeString(String S) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem767 prob = new Problem767();
        System.out.println(prob.reorganizeString("aab")); // aba
        System.out.println(prob.reorganizeString("aaab")); //
        System.out.println(prob.reorganizeString("aaabb")); // ababa
        System.out.println(prob.reorganizeString("babab")); // ababa
    }
}
