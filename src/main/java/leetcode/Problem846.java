package leetcode;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/hand-of-straights/
 */
public class Problem846 {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            if (!map.containsKey(hand[i])) {
                map.put(hand[i], 1);
            } else {
                map.put(hand[i], map.get(hand[i]) + 1);
            }
        }
        boolean result = true;
        while (!map.isEmpty()) {
            Entry<Integer, Integer> first = map.firstEntry();
            int prevKey = first.getKey();
            int newPrevVal = first.getValue() - 1;
            if (newPrevVal == 0) {
                map.remove(prevKey);
            } else {
                map.put(prevKey, newPrevVal);
            }
            for (int i = 0; i < W - 1; i++) {
                int curKey = prevKey + 1;
                if (!map.containsKey(curKey)) {
                    return false;
                }
                int curVal = map.get(curKey);
                int newCurValue = curVal - 1;
                if (newCurValue == 0) {
                    map.remove(curKey);
                } else {
                    map.put(curKey, newCurValue);
                }
                prevKey = curKey;
            }
        }
        return result;
    }
}
