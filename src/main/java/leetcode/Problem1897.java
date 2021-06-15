package leetcode;

/**
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
 */
public class Problem1897 {
    public boolean makeEqual(String[] words) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1897 prob = new Problem1897();
        System.out.println(prob.makeEqual(new String[]{"abc","aabc","bc"})); // true
        System.out.println(prob.makeEqual(new String[]{"ab","a"})); // false
    }
}
