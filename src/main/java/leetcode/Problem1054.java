package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/distant-barcodes/
 */
public class Problem1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            if (!map.containsKey(barcode)) {
                map.put(barcode, 1);
            } else {
                map.put(barcode, map.get(barcode) + 1);
            }
        }
        PriorityQueue<ValueCount> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            queue.add(new ValueCount(e.getKey(), e.getValue()));
        }
        int[] answer = new int[barcodes.length];
        int i = 0;
        List<ValueCount> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            while (i - 1 >= 0 && answer[i - 1] == queue.peek().value) {
                tmp.add(queue.remove());
            }
            ValueCount valueCount = queue.remove();
            answer[i++] = valueCount.value;
            valueCount.count--;
            if (valueCount.count > 0) {
                queue.add(valueCount);
            }
            for (ValueCount vc : tmp) {
                queue.add(vc);
            }
            tmp.clear();
        }
        return answer;
    }

    private static class ValueCount {
        private final int value;
        private int count;

        public ValueCount(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
