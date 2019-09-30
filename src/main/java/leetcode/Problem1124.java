package leetcode;

/**
 * https://leetcode.com/problems/longest-well-performing-interval/
 */
public class Problem1124 {
    public int longestWPI(int[] hours) {
        int answer = 0;
        for (int i = 0; i < hours.length; i++) {
            int tiring = 0;
            int nonTiring = 0;
            for (int j = i; j < hours.length; j++) {
                if (hours[j] <= 8) {
                    nonTiring++;
                } else {
                    tiring++;
                }
                if (tiring > nonTiring) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1124 prob = new Problem1124();
        System.out.println(prob.longestWPI(new int[]{9,9,6,0,6,6,9})); // 3
        System.out.println(prob.longestWPI(new int[]{8,6,9,9,10,9,0,6,6,9})); // 9
    }
}
