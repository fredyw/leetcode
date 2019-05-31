package leetcode;

/**
 * https://leetcode.com/problems/grumpy-bookstore-owner/
 */
public class Problem1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int satisfiedSum = 0;
        for (int i = 0; i < customers.length; i++) {
            satisfiedSum += customers[i];
        }
        int[] grumpySums = new int[grumpy.length];
        for (int i = 0; i < grumpy.length; i++) {
            if (i == 0) {
                if (grumpy[i] == 1) {
                    grumpySums[i] = customers[i];
                }
            } else {
                if (grumpy[i] == 1) {
                    grumpySums[i] = grumpySums[i - 1] + customers[i];
                } else {
                    grumpySums[i] = grumpySums[i - 1];
                }
            }
        }
        int grumpySum = grumpySums[grumpySums.length - 1];
        int answer = satisfiedSum - grumpySum;
        for (int i = X - 1; i < grumpySums.length; i++) {
            int val = 0;
            if (i - X < 0) {
                val = (satisfiedSum - grumpySum) + grumpySums[i];
            } else {
                val = (satisfiedSum - grumpySum) + (grumpySums[i] - grumpySums[i - X]);
            }
            answer = Math.max(answer, val);
        }
        return answer;
    }
}
