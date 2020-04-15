package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
            List<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(map.get(a).entrySet());
            List<Map.Entry<Integer, Integer>> list2 = new ArrayList<>(map.get(b).entrySet());
            int size = Math.max(list1.size(), list2.size());
            int i = 0;
            while (i < size) {
                Map.Entry<Integer, Integer> entry1 = list1.get(i);
                Map.Entry<Integer, Integer> entry2 = list2.get(i);
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
                i++;
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

    public static void main(String[] args) {
        Problem1366 prob = new Problem1366();
        System.out.println(prob.rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"})); // "ABC"
        System.out.println(prob.rankTeams(new String[]{"WXYZ","XYZW"})); // "XWYZ"
        System.out.println(prob.rankTeams(new String[]{"ABC","CBA"})); // "ABC"
        System.out.println(prob.rankTeams(new String[]{"ABDC","CDBA"})); // "ACBD"
        System.out.println(prob.rankTeams(new String[]{"CBDA","ADBC"})); // "ACBD"
        System.out.println(prob.rankTeams(new String[]{"WYXZ","XYZW"})); // "XWYZ"
        System.out.println(prob.rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"})); // "ZMNAGUEDSJYLBOPHRQICWFXTVK"
        System.out.println(prob.rankTeams(new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"})); // "ABC"
        System.out.println(prob.rankTeams(new String[]{"M","M","M","M"})); // "M"
    }
}
