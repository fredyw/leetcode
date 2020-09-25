package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/find-the-winner-of-an-array-game/
 */
public class Problem1535 {
    public int getWinner(int[] arr, int k) {
        int first = 0;
        int last = arr.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int second = (first + 1) % arr.length;
            if (arr[first] > arr[second]) {
                int count = map.getOrDefault(arr[first], 0) + 1;
                if (count == k) {
                    return arr[first];
                }
                map.put(arr[first], count);
                int tmp = arr[second];
                arr[second] = arr[first];
                arr[first] = tmp;
            } else {
                int count = map.getOrDefault(arr[second], 0) + 1;
                if (count == k) {
                    return arr[second];
                }
                map.put(arr[second], count);
            }
            first = (first + 1) % arr.length;
            last = (last + 1) % arr.length;
        }
        return IntStream.of(arr).max().getAsInt();
    }
}
