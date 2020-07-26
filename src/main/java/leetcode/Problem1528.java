package leetcode;

/**
 * https://leetcode.com/problems/shuffle-string/
 */
public class Problem1528 {
    public String restoreString(String s, int[] indices) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1528 prob = new Problem1528();
        System.out.println(prob.restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3})); // "leetcode"
        System.out.println(prob.restoreString("abc", new int[]{0,1,2})); // "abc"
        System.out.println(prob.restoreString("aiohn", new int[]{3,1,4,2,0})); // "nihao"
        System.out.println(prob.restoreString("aaiougrt", new int[]{4,0,2,6,7,3,1,53})); // "arigatou"
        System.out.println(prob.restoreString("art", new int[]{1,0,2})); // "rat"
    }
}
