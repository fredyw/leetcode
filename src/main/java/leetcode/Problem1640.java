package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/check-array-formation-through-concatenation/
 */
public class Problem1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map</* first element */ Integer, /* index */ Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            // We only care about the first index because the integers are distinct.
            map.put(pieces[i][0], i);
        }
        int i = 0;
        while (i < arr.length) {
            int a = arr[i];
            if (!map.containsKey(a)) {
                return false;
            }
            int index = map.get(a);
            for (int b : pieces[index]) {
                if (i < arr.length && b != arr[i++]) {
                    return false;
                }
            }
        }
        return true;
    }
}
