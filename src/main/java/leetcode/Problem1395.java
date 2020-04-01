package leetcode;

/**
 * https://leetcode.com/problems/count-number-of-teams/
 */
public class Problem1395 {
    public int numTeams(int[] rating) {
        int[] greater = new int[rating.length];
        int[] smaller = new int[rating.length];
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    greater[j]++;
                } else if (rating[i] > rating[j]) {
                    smaller[i]++;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    answer += greater[i];
                } else if (rating[i] > rating[j]) {
                    answer += smaller[j];
                }
            }
        }
        return answer;
    }
}
