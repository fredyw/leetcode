package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-an-ordered-stream/
 */
public class Problem1656 {
    static class OrderedStream {
        private final String[] strings;
        private int ptr;

        public OrderedStream(int n) {
            strings = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int id, String value) {
            List<String> list = new ArrayList<>();
            strings[id] = value;
            if (ptr == id && strings[id] != null) {
                int i = id;
                for (; i < strings.length && strings[i] != null; i++) {
                    list.add(strings[i]);
                }
                ptr = i;
            }
            return list;
        }
    }
}
