package leetcode;

/**
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/
 */
public class Problem893 {
    public int numSpecialEquivGroups(String[] A) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem893 prob = new Problem893();
        System.out.println(prob.numSpecialEquivGroups(new String[]{"a","b","c","a","c","c"})); // 3
        System.out.println(prob.numSpecialEquivGroups(new String[]{"aa","bb","ab","ba"})); // 4
        System.out.println(prob.numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"})); // 3
        System.out.println(prob.numSpecialEquivGroups(new String[]{"abcd","cdab","adcb","cbad"})); // 1
    }
}
