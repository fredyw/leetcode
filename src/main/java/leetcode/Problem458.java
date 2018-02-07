package leetcode;

/**
 * https://leetcode.com/problems/poor-pigs/
 */
public class Problem458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution
        int pigs = 0;
        while (Math.pow((minutesToTest / minutesToDie + 1), pigs) < buckets) {
            pigs += 1;
        }
        return pigs;
    }
}
