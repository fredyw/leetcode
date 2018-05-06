package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/positions-of-large-groups/
 */
public class Problem830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem830 prob = new Problem830();
        System.out.println(prob.largeGroupPositions("abbxxxxzzy")); // [[3,6]]
        System.out.println(prob.largeGroupPositions("abc")); // []
        System.out.println(prob.largeGroupPositions("abcdddeeeeaabbbcd")); // [[3,5],[6,9],[12,14]]
    }
}
