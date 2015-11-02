package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class Problem299 {
    public String getHint(String secret, String guess) {
        Set<String> idxChars = new HashSet<>();
        Map<Character, Integer> counts = new HashMap<>();
        char[] charArray = secret.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            String key = "" + i + "|" + charArray[i];
            if (!idxChars.contains(key)) {
                idxChars.add(key);
            }
            if (!counts.containsKey(charArray[i])) {
                counts.put(charArray[i], 1);
            } else {
                counts.put(charArray[i], counts.get(charArray[i]) + 1);
            }
        }
        int nBull = 0;
        charArray = guess.toCharArray();
        Set<Integer> bulls = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) {
            String key = "" + i + "|" + charArray[i];
            if (idxChars.contains(key)) {
                nBull++;
                bulls.add(i);
                counts.put(charArray[i], counts.get(charArray[i]) - 1);
            }
        }
        int nCow = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (bulls.contains(i)) {
                continue;
            }
            if (counts.containsKey(charArray[i])) {
                if (counts.get(charArray[i]) > 0) {
                    nCow++;
                }
                counts.put(charArray[i], counts.get(charArray[i]) - 1);
            }
        }
        return nBull + "A" + nCow + "B";
    }
}
