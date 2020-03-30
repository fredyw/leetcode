package leetcode;

/**
 * https://leetcode.com/problems/count-number-of-teams/
 */
public class Problem1395 {
    public int numTeams(int[] rating) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1395 prob = new Problem1395();
        System.out.println(prob.numTeams(new int[]{2,5,3,4,1})); // 3
        System.out.println(prob.numTeams(new int[]{2,1,3})); // 0
        System.out.println(prob.numTeams(new int[]{1,2,3,4})); // 4
    }
}
