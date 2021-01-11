package leetcode;

/**
 * https://leetcode.com/problems/decode-xored-array/
 */
public class Problem1720 {
    public int[] decode(int[] encoded, int first) {
        int[] answer = new int[encoded.length + 1];
        answer[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            answer[i + 1] = answer[i] ^ encoded[i];
        }
        return answer;
    }
}
