package leetcode;

/**
 * https://leetcode.com/problems/count-the-number-of-consistent-strings/
 */
public class Problem1684 {
    public int countConsistentStrings(String allowed, String[] words) {
         // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1684 prob = new Problem1684();
        System.out.println(prob.countConsistentStrings("ab", new String[]{"ad","bd","aaab","baa","badab"})); // 2
        System.out.println(prob.countConsistentStrings("abc", new String[]{"a","b","c","ab","ac","bc","abc"})); // 7
        System.out.println(prob.countConsistentStrings("cad", new String[]{"cc","acd","b","ba","bac","bad","ac","d"})); // 4
    }
}
