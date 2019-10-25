package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/can-make-palindrome-from-substring/
 */
public class Problem1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1177 prob = new Problem1177();
        System.out.println(prob.canMakePaliQueries("abcda", new int[][]{
            {3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}
        })); // [true,false,false,true,true]
    }
}
