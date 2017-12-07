package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 */
public class Problem739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int j = 1;
        for (int i = 0; i < temperatures.length - 1; i++) {
            if (temperatures[i] < temperatures[j]) {
                result[i] = j - i;
            } else {
                stack.push(i);
            }
        }

//        int i = 0;
//        int j = 1;
//        int count = 1;
//        while (i < temperatures.length) {
//            if (j == temperatures.length) {
//                count = 1;
//                i++;
//                j = i + 1;
//                continue;
//            }
//            if (temperatures[i] < temperatures[j++]) {
//                result[i++] = count;
//                count = 1;
//                j = i + 1;
//            } else {
//                count++;
//            }
//        }
        return result;
    }

    public static void main(String[] args) {
        Problem739 prob = new Problem739();
        System.out.println(Arrays.toString(prob.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))); // [1, 1, 4, 2, 1, 1, 0, 0]
//        System.out.println(Arrays.toString(prob.dailyTemperatures(new int[]{73, 73}))); // [0, 0]
//        System.out.println(Arrays.toString(prob.dailyTemperatures(new int[]{73, 72, 71, 70}))); // [0, 0, 0, 0]
//        System.out.println(Arrays.toString(prob.dailyTemperatures(new int[]{55, 38, 53, 81, 61, 93, 97, 32, 43, 78}))); // [3,1,1,2,1,1,0,1,1,0]
    }
}
