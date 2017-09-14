package leetcode;

/**
 * https://leetcode.com/problems/dota2-senate/
 */
public class Problem649 {
    public String predictPartyVictory(String senate) {
        int radiantCount = 0;
        int direCount = 0;
        char[] chars = senate.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                radiantCount++;
            } else {
                direCount++;
            }
        }
        while (direCount > 0 || radiantCount > 0) {
            for (int i = 0; i < chars.length; i++) {
                if (direCount == 0) {
                    return "Radiant";
                }
                if (radiantCount == 0) {
                    return "Dire";
                }
                if (chars[i] == 'R') {
                    int j = (i + 1) % chars.length;
                    while (chars[j] != 'D') {
                        j++;
                        j = j % chars.length;
                    }
                    chars[j] = ' ';
                    direCount--;
                } else if (chars[i] == 'D') {
                    int j = (i + 1) % chars.length;
                    while (chars[j] != 'R') {
                        j++;
                        j = j % chars.length;
                    }
                    chars[j] = ' ';
                    radiantCount--;
                }
            }
        }
        if (direCount == 0) {
            return "Radiant";
        }
        return "Dire";
    }

    public static void main(String[] args) {
        Problem649 prob = new Problem649();
        System.out.println(prob.predictPartyVictory("RD")); // Radiant
        System.out.println(prob.predictPartyVictory("RDD")); // Dire
        System.out.println(prob.predictPartyVictory("RDRD")); // Radiant
        System.out.println(prob.predictPartyVictory("RDDR")); // Radiant
        System.out.println(prob.predictPartyVictory("R")); // Radiant
        System.out.println(prob.predictPartyVictory("D")); // Dire
        System.out.println(prob.predictPartyVictory("DDRRR")); // Dire
        System.out.println(prob.predictPartyVictory("RDDRDDDRRRDDRDRDRDDDDRRDR")); // Dire
        System.out.println(prob.predictPartyVictory("DRRDRDRDRDDRDRDR")); // Radiant
    }
}
