package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/dota2-senate/
 */
public class Problem649 {
    public String predictPartyVictory(String senate) {
        List<Integer> radiants = new ArrayList<>();
        List<Integer> dires = new ArrayList<>();
        char[] chars = senate.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                radiants.add(i);
            } else {
                dires.add(i);
            }
        }
        int radiantIdx = 0;
        int direIdx = 0;
        Set<Integer> bannedRadiants = new HashSet<>();
        Set<Integer> bannedDires = new HashSet<>();
        while (bannedRadiants.size() <= radiants.size() || bannedDires.size() <= dires.size()) {
            for (int i = 0; i < chars.length; i++) {
                if (bannedRadiants.size() == radiants.size()) {
                    return "Dire";
                }
                if (bannedDires.size() == dires.size()) {
                    return "Radiant";
                }
                if (chars[i] == 'R') {
                    if (bannedRadiants.contains(i)) {
                        continue;
                    }
                    bannedDires.add(dires.get(direIdx++));
                } else {
                    if (bannedDires.contains(i)) {
                        continue;
                    }
                    bannedRadiants.add(radiants.get(radiantIdx++));
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Problem649 prob = new Problem649();
//        System.out.println(prob.predictPartyVictory("RD")); // Radiant
//        System.out.println(prob.predictPartyVictory("RDD")); // Dire
//        System.out.println(prob.predictPartyVictory("RDRD")); // Radiant
//        System.out.println(prob.predictPartyVictory("RDDR")); // Radiant
//        System.out.println(prob.predictPartyVictory("R")); // Radiant
//        System.out.println(prob.predictPartyVictory("D")); // Dire
//        System.out.println(prob.predictPartyVictory("DDRRR")); // Dire
//        System.out.println(prob.predictPartyVictory("RDDRDDDRRRDDRDRDRDDDDRRDR")); // Dire
        System.out.println(prob.predictPartyVictory("DRRDRDRDRDDRDRDR")); // Radiant
    }
}
