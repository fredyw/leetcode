package leetcode;

/**
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */
public class Problem1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1662 prob = new Problem1662();
        System.out.println(prob.arrayStringsAreEqual(
            new String[]{"ab", "c"}, new String[]{"a", "bc"})); // true
        System.out.println(prob.arrayStringsAreEqual(
            new String[]{"a", "cb"}, new String[]{"ab", "c"})); // false
        System.out.println(prob.arrayStringsAreEqual(
            new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"})); // true
    }
}
