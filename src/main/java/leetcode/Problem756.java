package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/pyramid-transition-matrix/
 */
public class Problem756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String first = s.substring(0, 2);
            char second = s.charAt(2);
            if (!map.containsKey(first)) {
                List<Character> list = new ArrayList<>();
                list.add(second);
                map.put(first, list);
            } else {
                map.get(first).add(second);
            }
        }
        List<List<Character>> matrix = new ArrayList<>();
        for (int i = 0; i < bottom.length(); i++) {
            matrix.add(new ArrayList<>());
            matrix.get(0).add(bottom.charAt(i));
        }
        return pyramidTransition(bottom, map, matrix, 0, 0);
    }

    private static boolean pyramidTransition(String bottom,
                                             Map<String, List<Character>> map,
                                             List<List<Character>> matrix,
                                             int row,
                                             int col) {
        if (col + 1 >= matrix.get(row).size()) {
            row++;
            col = 0;
        }
        if (row == bottom.length() - 1 && matrix.get(row).size() == 1) {
            return true;
        }
        char c1 = matrix.get(row).get(col);
        char c2 = matrix.get(row).get(col + 1);
        String s = "" + c1 + c2;
        if (!map.containsKey(s)) {
            return false;
        }
        List<Character> chars = map.get(s);
        boolean found = false;
        for (Character ch : chars) {
            int idx = matrix.get(row + 1).size();
            matrix.get(row + 1).add(ch);
            found |= pyramidTransition(bottom, map, matrix, row, col + 1);
            if (found) {
                return true;
            }
            matrix.get(row + 1).remove(idx);
        }
        return false;
    }
}
