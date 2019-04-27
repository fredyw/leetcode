package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 */
public class Problem336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem336 prob = new Problem336();
        System.out.println(prob.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"})); // [[0,1],[1,0],[3,2],[2,4]]
        System.out.println(prob.palindromePairs(new String[]{"bat", "tab", "cat"})); // [[0,1],[1,0]]
    }
}
