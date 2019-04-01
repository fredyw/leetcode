package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-prefix-divisible-by-5/
 */
public class Problem1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> answer = new ArrayList<>();
        // TODO
        return answer;
    }

    public static void main(String[] args) {
        Problem1018 prob = new Problem1018();
        System.out.println(prob.prefixesDivBy5(new int[]{0, 1, 1})); // [true,false,false]
        System.out.println(prob.prefixesDivBy5(new int[]{1, 1, 1})); // [false,false,false]
        System.out.println(prob.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1})); // [true,false,false,false,true,false]
    }
}
