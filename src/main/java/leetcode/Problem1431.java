package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class Problem1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1431 prob = new Problem1431();
        System.out.println(prob.kidsWithCandies(new int[]{2,3,5,1,3}, 3)); // [true,true,true,false,true]
        System.out.println(prob.kidsWithCandies(new int[]{4,2,1,1,2}, 1)); // [true,false,false,false,false]
        System.out.println(prob.kidsWithCandies(new int[]{12,1,12}, 10)); // [true,false,true]
    }
}
