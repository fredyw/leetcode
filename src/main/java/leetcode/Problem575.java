package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/distribute-candies/
 */
public class Problem575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            if (set.size() == candies.length / 2) {
                break;
            }
            set.add(candies[i]);
        }
        return set.size();
    }
}
