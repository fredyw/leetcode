package leetcode;

/**
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 */
public class Problem1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int answer = 0;
        for (int i = 1; i <= 1000000; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += -Math.floorDiv(-num, i); // opposite of ceilDiv
            }
            if (sum <= threshold) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1283 prob = new Problem1283();
        System.out.println(prob.smallestDivisor(new int[]{1, 2, 5, 9}, 6)); // 5
        System.out.println(prob.smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11)); // 3
        System.out.println(prob.smallestDivisor(new int[]{19}, 5)); // 4
    }
}
