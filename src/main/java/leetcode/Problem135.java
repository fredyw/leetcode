package leetcode;

/**
 * https://leetcode.com/problems/candy/
 */
public class Problem135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // forward
        int i = 0;
        while (i < ratings.length) {
            while (i + 1 < ratings.length && ratings[i] < ratings[i + 1]) {
                if (candies[i] == 0) {
                    candies[i] = 1;
                }
                candies[i + 1] = candies[i] + 1;
                i++;
            }
            i++;
        }
        // backward
        i = ratings.length - 1;
        while (i >= 0) {
            while (i - 1 >= 0 && ratings[i - 1] > ratings[i]) {
                if (candies[i] == 0) {
                    candies[i] = 1;
                }
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
                i--;
            }
            i--;
        }
        int answer = 0;
        for (int candy : candies) {
            if (candy == 0) {
                answer++;
            } else {
                answer += candy;
            }
        }
        return answer;
    }
}
