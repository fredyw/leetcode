package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/heaters/
 */
public class Problem475 {
    public int findRadius(int[] houses, int[] heaters) {
        List<Element> list = new ArrayList<>();
        for (int house : houses) {
            list.add(new Element(house, false));
        }
        for (int heater : heaters) {
            list.add(new Element(heater, true));
        }
        Collections.sort(list, (a, b) -> {
            int cmp = Integer.compare(a.position, b.position);
            if (cmp == 0) {
                if (a.heater) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return cmp;
        });
        int idx = 0;
        while (idx < list.size()) {
            if (list.get(idx).heater) {
                break;
            }
            idx++;
        }
        while (idx < list.size()) {
            Element heater = list.get(idx);
            int left = idx - 1;
            while (left >= 0 && !list.get(left).heater) {
                Element nonHeater = list.get(left);
                nonHeater.radius = Math.min(nonHeater.radius, Math.abs(heater.position - nonHeater.position));
                left--;
            }
            int right = idx + 1;
            while (right < list.size() && !list.get(right).heater) {
                Element nonHeater = list.get(right);
                nonHeater.radius = Math.min(nonHeater.radius, Math.abs(heater.position - nonHeater.position));
                right++;
            }
            idx = right;
        }
        int result = 0;
        for (Element e : list) {
            if (!e.heater) {
                result = Math.max(e.radius, result);
            }
        }
        return result;
    }

    private static class Element {
        private final int position;
        private final boolean heater;
        private int radius = Integer.MAX_VALUE;

        public Element(int position, boolean heater) {
            this.position = position;
            this.heater = heater;
        }
    }
}
