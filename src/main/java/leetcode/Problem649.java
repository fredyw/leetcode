package leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/dota2-senate/
 */
public class Problem649 {
    public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        TreeSet<Integer> radiants = new TreeSet<>();
        TreeSet<Integer> dires = new TreeSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                radiants.add(i);
            } else {
                dires.add(i);
            }
        }
        while (dires.size() > 0 || radiants.size() > 0) {
            for (int i = 0; i < chars.length; i++) {
                if (dires.size() == 0) {
                    return "Radiant";
                }
                if (radiants.size() == 0) {
                    return "Dire";
                }
                if (chars[i] == 'R') {
                    Integer idx = dires.ceiling(i + 1);
                    if (idx == null) {
                        idx = dires.first();
                    }
                    chars[idx] = ' ';
                    dires.remove(idx);
                } else if (chars[i] == 'D') {
                    Integer idx = radiants.ceiling(i + 1);
                    if (idx == null) {
                        idx = radiants.first();
                    }
                    chars[idx] = ' ';
                    radiants.remove(idx);
                }
            }
        }
        if (dires.size() == 0) {
            return "Radiant";
        }
        return "Dire";
    }
}
