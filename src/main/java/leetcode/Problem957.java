package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/prison-cells-after-n-days/
 */
public class Problem957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> cellToDay = new HashMap<>();
        Map<Integer, int[]> dayToCell = new HashMap<>();
        int diff = 0;
        for (int i = 0; i < N; i++) {
            int[] tmp = new int[cells.length];
            for (int j = 0; j < cells.length; j++) {
                if (j - 1 < 0 || j + 1 == cells.length) {
                    tmp[j] = 0;
                } else if ((cells[j - 1] == 0 && cells[j + 1] == 0) ||
                    (cells[j - 1] == 1 && cells[j + 1] == 1)) {
                    tmp[j] = 1;
                } else {
                    tmp[j] = 0;
                }
            }
            cells = tmp;
            dayToCell.put(i, cells);
            String s = Arrays.toString(cells);
            if (!cellToDay.containsKey(s)) {
                cellToDay.put(s, i);
            } else {
                diff = i - cellToDay.get(s);
                break;
            }
        }
        if (diff == 0) {
            return cells;
        }
        return dayToCell.get((N - 1) % diff);
    }
}
