package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/can-make-palindrome-from-substring/
 */
public class Problem1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> answer = new ArrayList<>();
        for (int[] query : queries) {
            String sub = s.substring(query[0], query[1] + 1);
            int count = 0;
            for (int i = 0, j = sub.length() - 1; i < j; i++, j--) {
                if (sub.charAt(i) != sub.charAt(j)) {
                    count++;
                }
                if (count > query[2]) {
                    break;
                }
            }
            answer.add(count <= query[2]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1177 prob = new Problem1177();
//        System.out.println(prob.canMakePaliQueries("abcda", new int[][]{
//            {3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}
//        })); // [true,false,false,true,true]
        System.out.println(prob.canMakePaliQueries("hunu", new int[][]{
            {1,1,1},{2,3,0},{3,3,1},{0,3,2},{1,3,3},{2,3,1},{3,3,1},{0,3,0},{1,1,1},{2,3,0},{3,3,1},{0,3,1},{1,1,1}
        })); // [true,false,true,true,true,true,true,false,true,false,true,true,true]
    }
}
