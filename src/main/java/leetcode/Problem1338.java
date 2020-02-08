package leetcode;

/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 */
public class Problem1338 {
    public int minSetSize(int[] arr) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1338 prob = new Problem1338();
        System.out.println(prob.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7})); // 2
        System.out.println(prob.minSetSize(new int[]{7,7,7,7,7,7})); // 1
        System.out.println(prob.minSetSize(new int[]{1,9})); // 1
        System.out.println(prob.minSetSize(new int[]{1000,1000,3,7})); // 1
        System.out.println(prob.minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10})); // 5
    }
}
