package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/tuple-with-same-product/
 */
public class Problem1726 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                map.put(product, map.getOrDefault(product, 0) + 1);
            }
        }
        int answer = 0;
        for (int count : map.values()) {
            if (count <= 1) {
                continue;
            }
            int totalCount = 0;
            for (int i = 1; i < count; i++) {
                totalCount += i;
            }
            answer += totalCount;
        }
        return answer * 8;
    }
}
