package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/rank-teams-by-votes/
 */
public class Problem1366 {
    public String rankTeams(String[] votes) {
        Map<Integer, Map<Character, Integer>> map = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                if (!map.containsKey(i)) {
                    map.put(i, new HashMap<>());
                }
                map.get(i).put(vote.charAt(i), map.get(i).getOrDefault(vote.charAt(i), 0) + 1);
            }
        }
        System.out.println(map);
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
