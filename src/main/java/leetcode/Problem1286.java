package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/iterator-for-combination/
 */
public class Problem1286 {
    private static class CombinationIterator {
        private final List<String> combinations = new ArrayList<>();
        private int index;

        public CombinationIterator(String characters, int combinationLength) {
            generateCombinations(characters, combinationLength, 0, "", combinations);
        }

        public String next() {
            return combinations.get(index++);
        }

        public boolean hasNext() {
            return index < combinations.size();
        }

        private static void generateCombinations(String str, int length, int index, String accu,
                                                 List<String> combinations) {
            if (accu.length() == length) {
                combinations.add(accu);
                return;
            }
            for (int i = index; i < str.length(); i++) {
                char c = str.charAt(i);
                generateCombinations(str, length, i + 1, accu + c, combinations);
            }
        }
    }
}
