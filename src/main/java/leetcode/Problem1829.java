package leetcode;

/**
 * https://leetcode.com/problems/maximum-xor-for-each-query/
 */
public class Problem1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] answer = new int[nums.length];
        int prefixXor = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixXor ^= nums[i];
            int k = ((int) Math.pow(2, maximumBit)) - 1;
            // a ^ b = c --> a ^ c = b
            answer[nums.length - 1 - i] = prefixXor ^ k;
        }
        return answer;
    }
}
