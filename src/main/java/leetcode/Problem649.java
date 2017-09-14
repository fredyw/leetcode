package leetcode;

/**
 * https://leetcode.com/problems/dota2-senate/
 */
public class Problem649 {
    public String predictPartyVictory(String senate) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem649 prob = new Problem649();
        System.out.println(prob.predictPartyVictory("RD")); // Radiant
        System.out.println(prob.predictPartyVictory("RDD")); // Dire
        System.out.println(prob.predictPartyVictory("RDRD")); // Radiant
        System.out.println(prob.predictPartyVictory("RDDR")); // Radiant
    }
}
