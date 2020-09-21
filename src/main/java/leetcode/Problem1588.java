package leetcode;

/**
 * https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */
public class Problem1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1588 prob = new Problem1588();
        System.out.println(prob.sumOddLengthSubarrays(new int[]{1,4,2,5,3})); // 58
        System.out.println(prob.sumOddLengthSubarrays(new int[]{1,2})); // 3
        System.out.println(prob.sumOddLengthSubarrays(new int[]{10,11,12})); // 66
    }
}
