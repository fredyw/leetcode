package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/vowel-spellchecker/
 */
public class Problem966 {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> ignoreVowel = new HashMap<>();
        for (String word : wordlist) {
            exact.add(word);
            String lower = word.toLowerCase();
            if (!caseInsensitive.containsKey(lower)) {
                caseInsensitive.put(lower, word);
            }
            String changeVowel = changeVowel(lower);
            if (!ignoreVowel.containsKey(changeVowel)) {
                ignoreVowel.put(changeVowel, word);
            }
        }
        String[] answer = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (exact.contains(queries[i])) {
                answer[i] = queries[i];
            } else if (caseInsensitive.containsKey(queries[i].toLowerCase())) {
                answer[i] = caseInsensitive.get(queries[i].toLowerCase());
            } else if (ignoreVowel.containsKey(changeVowel(queries[i].toLowerCase()))) {
                answer[i] = ignoreVowel.get(changeVowel(queries[i].toLowerCase()));
            } else {
                answer[i] = "";
            }
        }
        return answer;
    }

    private static String changeVowel(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'u' ||
                chars[i] == 'i' || chars[i] == 'o') {
                chars[i] = 'a';
            }
        }
        return new String(chars);
    }
}
