package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/rank-teams-by-votes/
 */
public class Problem1366 {
    public String rankTeams(String[] votes) {
        Map<Integer, Map<Character, Integer>> rankMap = new HashMap<>();
        Map<Character, Set<Integer>> charMap = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                if (!rankMap.containsKey(i)) {
                    rankMap.put(i, new HashMap<>());
                }
                rankMap.get(i).put(vote.charAt(i), rankMap.get(i).getOrDefault(vote.charAt(i), 0) + 1);
                if (!charMap.containsKey(vote.charAt(i))) {
                    charMap.put(vote.charAt(i), new HashSet<>());
                }
                charMap.get(vote.charAt(i)).add(i);
            }
        }
        System.out.println(rankMap);
        System.out.println(charMap);
        return null;
    }

    public static void main(String[] args) {
        Problem1366 prob = new Problem1366();
        System.out.println(prob.rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"})); // "ABC"
        System.out.println(prob.rankTeams(new String[]{"WXYZ","XYZW"})); // "XWYZ"
//        System.out.println(prob.rankTeams(new String[]{"ABC","CBA"})); // "ABC"
//        System.out.println(prob.rankTeams(new String[]{"ABDC","CDBA"})); // "ACBD"
//        System.out.println(prob.rankTeams(new String[]{"CBDA","ADBC"})); // "ACBD"
//        System.out.println(prob.rankTeams(new String[]{"WYXZ","XYZW"})); // "XWYZ"
//        System.out.println(prob.rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"})); // "ZMNAGUEDSJYLBOPHRQICWFXTVK"
//        System.out.println(prob.rankTeams(new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"})); // "ABC"
//        System.out.println(prob.rankTeams(new String[]{"M","M","M","M"})); // "M"
    }
}
