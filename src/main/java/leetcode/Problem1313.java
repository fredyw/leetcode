package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/decompress-run-length-encoded-list/
 */
public class Problem1313 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> decompresssed = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int a = nums[i];
            int b = nums[i + 1];
            for (int j = 0; j < a; j++) {
                decompresssed.add(b);
            }
        }
        int[] answer = new int[decompresssed.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = decompresssed.get(i);
        }
        return answer;
    }
}
