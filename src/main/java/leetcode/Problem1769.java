package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 */
public class Problem1769 {
    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int count = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (j == i || boxes.charAt(j) == '0') {
                    continue;
                }
                count += Math.abs(i - j);
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1769 prob = new Problem1769();
        System.out.println(Arrays.toString(prob.minOperations("110"))); // [1,1,3]
        System.out.println(Arrays.toString(prob.minOperations("001011"))); // [11,8,5,4,3,4]
    }
}
