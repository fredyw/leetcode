package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
 */
public class Problem1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        // 4jumbo + 2small = tomato
        // 1jumbo + 1small = cheese
        // small = cheese - jumbo
        // jumbo = (tomato - 2cheese) / 2
        int jumbo = (tomatoSlices - (2 * cheeseSlices)) % 2 == 0 ? (tomatoSlices - (2 * cheeseSlices)) / 2 : -1;
        int small = cheeseSlices - jumbo;
        if (jumbo < 0 || small < 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(jumbo, small);
    }
}
