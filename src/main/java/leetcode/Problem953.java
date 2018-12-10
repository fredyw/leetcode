package leetcode;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class Problem953 {
    public boolean isAlienSorted(String[] words, String order) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem953 prob = new Problem953();
        System.out.println(prob.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz")); // true
        System.out.println(prob.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz")); // false
        System.out.println(prob.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz")); // false
    }
}
