package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/anagrams/
 */
public class Problem49 {
    public List<String> anagrams(String[] strs) {
        class Anagram {
            String sorted;
            String original;

            Anagram(String sorted, String original) {
                this.sorted = sorted;
                this.original = original;
            }
        }

        List<Anagram> sortedStrings = new ArrayList<>();
        for (String s : strs) {
            if (s.isEmpty()) {
                sortedStrings.add(new Anagram(s, s));
            } else {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                sortedStrings.add(new Anagram(new String(chars), s));
            }
        }

        List<String> result = new ArrayList<>();
        Set<Integer> ignored = new HashSet<>();
        for (int i = 0; i < sortedStrings.size(); i++) {
            for (int j = 0; j < sortedStrings.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (sortedStrings.get(i).sorted.equals(sortedStrings.get(j).sorted)) {
                    if (!ignored.contains(i)) {
                        result.add(sortedStrings.get(i).original);
                    }
                    ignored.add(i);
                }
            }
        }
        return result;
    }
}
