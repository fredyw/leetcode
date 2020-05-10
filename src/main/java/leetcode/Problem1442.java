package leetcode;

/**
 * https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class Problem1442 {
    public int countTriplets(int[] arr) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1442 prob = new Problem1442();
        System.out.println(prob.countTriplets(new int[]{2,3,1,6,7})); // 4
        System.out.println(prob.countTriplets(new int[]{1,1,1,1,1})); // 10
        System.out.println(prob.countTriplets(new int[]{2,3})); // 0
        System.out.println(prob.countTriplets(new int[]{1,3,5,7,9})); // 3
        System.out.println(prob.countTriplets(new int[]{7,11,12,9,5,2,7,17,22})); // 8
    }
}
