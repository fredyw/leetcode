package leetcode;

/**
 * https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class Problem1442 {
    public int countTriplets(int[] arr) {
        int[] xor = new int[arr.length + 1];
        for (int i = 1; i < xor.length; i++) {
            xor[i] = xor[i - 1] ^ arr[i - 1];
        }
        int answer = 0;
        for (int i = 0; i < xor.length; i++) {
            for (int j = i + 1; j < xor.length; j++) {
                if (xor[i] == xor[j]) {
                    answer += j - i - 1;
                }
            }
        }
        return answer;
    }
}
