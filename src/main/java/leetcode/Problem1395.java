package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-number-of-teams/
 */
public class Problem1395 {
    public int numTeamsBackward(int[] rating) {
        int answer = 0;
        for (int i = 0; i < rating.length; i++) {
            answer += numTeams(rating, i, i, 1);
        }
        int[] reversed = new int[rating.length];
        for (int i = rating.length - 1, j = 0; i >= 0; i--, j++) {
            reversed[j] = rating[i];
        }
        for (int i = 0; i < reversed.length; i++) {
            answer += numTeams(reversed, i, i, 1);
        }
        return answer;
    }

    private static int numTeams(int[] rating, int i, int j, int count) {
        if (count == 3) {
            return 1;
        }
        if (j == rating.length) {
            return 0;
        }
        if (rating[i] < rating[j]) {
            int a = numTeams(rating, i, j + 1, count);
            int b = numTeams(rating, j, j + 1, count + 1);
            return a + b;
        }
        return numTeams(rating, i, j + 1, count);
    }

    public static void main(String[] args) {
        Problem1395 prob = new Problem1395();
        System.out.println(prob.numTeamsBackward(new int[]{2,5,3,4,1})); // 3
        System.out.println(prob.numTeamsBackward(new int[]{2,1,3})); // 0
        System.out.println(prob.numTeamsBackward(new int[]{1,2,3,4})); // 4
    }
}
