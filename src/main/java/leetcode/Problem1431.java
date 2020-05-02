package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class Problem1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }
        List<Boolean> answer = new ArrayList<>();
        for (int candy : candies) {
            answer.add(candy + extraCandies >= maxCandy);
        }
        return answer;
    }
}
