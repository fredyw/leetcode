package leetcode;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 */
public class Problem1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1657 prob = new Problem1657();
        System.out.println(prob.closeStrings("abc", "bca")); // true
        System.out.println(prob.closeStrings("a", "aa")); // false
        System.out.println(prob.closeStrings("cabbba", "abbccc")); // true
        System.out.println(prob.closeStrings("cabbba", "aabbss")); // false
    }
}
