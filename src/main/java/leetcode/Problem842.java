package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/
 */
public class Problem842 {
    public List<Integer> splitIntoFibonacci(String S) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem842 prob = new Problem842();
        System.out.println(prob.splitIntoFibonacci("123456579")); // [123,456,579]
        System.out.println(prob.splitIntoFibonacci("11235813")); // [1,1,2,3,5,8,13]
        System.out.println(prob.splitIntoFibonacci("112358130")); // []
        System.out.println(prob.splitIntoFibonacci("0123")); // []
        System.out.println(prob.splitIntoFibonacci("1101111")); // [110, 1, 111]
    }
}
