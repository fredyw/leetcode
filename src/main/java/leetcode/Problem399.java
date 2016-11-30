package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * https://leetcode.com/problems/evaluate-division/
 */
public class Problem399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Set<StrValue>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String a = equations[i][0];
            String b = equations[i][1];
            double val = values[i];
            if (!map.containsKey(a)) {
                map.put(a, new HashSet<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new HashSet<>());
            }
            map.get(a).add(new StrValue(b, val));
            map.get(b).add(new StrValue(a, 1 / val));
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String a = queries[i][0];
            String b = queries[i][1];
            result[i] = getValue(a, b, map);
        }
        return result;
    }

    private double getValue(String a, String b, Map<String, Set<StrValue>> map) {
        if (map.get(a) == null || map.get(b) == null) {
            return -1;
        }
        LinkedList<StrValue> list = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        list.add(new StrValue(a, 1));
        visited.add(a);
        Map<StrValue, StrValue> paths = new HashMap<>();
        StrValue s = null;
        while (!list.isEmpty()) {
            s = list.remove();
            if (s.str.equals(b)) {
                break;
            }
            Set<StrValue> set = map.get(s.str);
            if (set == null) {
                continue;
            }
            for (StrValue adj : set) {
                if (!visited.contains(adj.str)) {
                    list.add(adj);
                    visited.add(adj.str);
                    paths.put(adj, s);
                }
            }
        }
        if (s == null || !s.str.equals(b)) {
            return -1;
        }
        double result = 1;
        while (s != null) {
            result *= s.val;
            s = paths.get(s);
        }
        return result;
    }

    private static class StrValue {
        private final String str;
        private final double val;

        public StrValue(String str, double val) {
            this.str = str;
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StrValue strValue = (StrValue) o;
            return Objects.equals(str, strValue.str);
        }

        @Override
        public int hashCode() {
            return Objects.hash(str);
        }
    }
}
