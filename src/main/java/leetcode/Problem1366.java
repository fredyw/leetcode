package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/rank-teams-by-votes/
 */
public class Problem1366 {
    public String rankTeams(String[] votes) {
        Map<Character, TreeMap</* rank */ Integer, /* count */ Integer>> map = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                if (!map.containsKey(vote.charAt(i))) {
                    map.put(vote.charAt(i), new TreeMap<>());
                }
                map.get(vote.charAt(i)).put(i, map.get(vote.charAt(i)).getOrDefault(i, 0) + 1);
            }
        }
        List<Character> chars = new ArrayList<>(map.keySet());
        Collections.sort(chars, (a, b) -> {
            Iterator<Map.Entry<Integer, Integer>> iter1 = map.get(a).entrySet().iterator();
            Iterator<Map.Entry<Integer, Integer>> iter2 = map.get(b).entrySet().iterator();
            while (iter1.hasNext() && iter2.hasNext()) {
                Map.Entry<Integer, Integer> entry1 = iter1.next();
                Map.Entry<Integer, Integer> entry2 = iter2.next();
                // Compare rank.
                int cmp = Integer.compare(entry1.getKey(), entry2.getKey());
                if (cmp != 0) {
                    return cmp;
                }
                // Compare number of votes.
                cmp = Integer.compare(entry2.getValue(), entry1.getValue());
                if (cmp != 0) {
                    return cmp;
                }
            }
            // Compare by character.
            return Character.compare(a, b);
        });
        String answer = "";
        for (char c : chars) {
            answer += c;
        }
        return answer;
    }
}
