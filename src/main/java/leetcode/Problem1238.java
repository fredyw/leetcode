package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/circular-permutation-in-binary-representation/
 */
public class Problem1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> answer = new ArrayList<>();
        answer.add(start);
        // TODO
        return answer;
    }

    private static int binaryToGray(int n) {
        // https://en.wikipedia.org/wiki/Gray_code
        return n ^ (n >> 1);
    }

    public static void main(String[] args) {
        Problem1238 prob = new Problem1238();
        System.out.println(prob.circularPermutation(2, 3)); // [3,2,0,1]
        System.out.println(prob.circularPermutation(3, 2)); // [2,6,7,5,4,0,1,3]
    }
}
