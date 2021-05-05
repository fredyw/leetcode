package leetcode;

/**
 * https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/
 */
public class Problem1850 {
    public int getMinSwaps(String num, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1850 prob = new Problem1850();
        System.out.println(prob.getMinSwaps("5489355142", 4)); // 2
        System.out.println(prob.getMinSwaps("11112", 4)); // 4
        System.out.println(prob.getMinSwaps("00123", 1)); // 1
    }
}
