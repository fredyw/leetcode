package leetcode;

/**
 * https://leetcode.com/problems/rank-teams-by-votes/
 */
public class Problem1366 {
    public String rankTeams(String[] votes) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1366 prob = new Problem1366();
        System.out.println(prob.rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"})); // "ABC"
        System.out.println(prob.rankTeams(new String[]{"WXYZ","XYZW"})); // "XWYZ"
        System.out.println(prob.rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"})); // "ZMNAGUEDSJYLBOPHRQICWFXTVK"
        System.out.println(prob.rankTeams(new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"})); // "ABC"
        System.out.println(prob.rankTeams(new String[]{"M","M","M","M"})); // "M"
    }
}
